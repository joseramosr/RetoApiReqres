package co.com.rappi.certificacion.reqresin.stepdefinitions;

import co.com.rappi.certificacion.reqresin.exceptions.ConsultUserException;
import co.com.rappi.certificacion.reqresin.models.Data;
import co.com.rappi.certificacion.reqresin.questions.TheResponseCodeObtained;
import co.com.rappi.certificacion.reqresin.questions.TheDataObtainedInTheUserQuery;
import co.com.rappi.certificacion.reqresin.tasks.ConsultAUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.rappi.certificacion.reqresin.exceptions.ConsultUserException.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class ConsultUserStepDefinition {

    private EnvironmentVariables environmentVariables;
    private String theApiUrl;

    @Before
    public void init(){
        setTheStage(new OnlineCast());
        theApiUrl = environmentVariables.optionalProperty("api.url").orElse("https://reqres.in/api");
    }


    @Given("^that the (.*) has access to the API$")
    public void thatTheAnalystHasAccessToTheAPI(String actorName) {
        theActorCalled(actorName).whoCan(CallAnApi.at(theApiUrl));
    }

    @When("^he makes the query of a user for his id (.*)$")
    public void heMakesTheQueryOfAUserForHisId(int userID) {
        theActorInTheSpotlight().attemptsTo(ConsultAUser.byId(userID));
    }

    @Then("^he should see the successful response code (.*)$")
    public void heShouldSeeTheSuccessfulResponseCode(int responseCode) {
        theActorInTheSpotlight().should(seeThat(TheResponseCodeObtained.is(), equalTo(responseCode))
                .orComplainWith(ConsultUserException.class, SUCCESSFUL_RESPONSE_CODE_MESSAGE_EXCEPTION));
    }

    @And("^that the response contains the id (.*) and email (.*) fields$")
    public void thatTheResponseContainsTheFieldsIdAndEmail(int id, String email) {
        Data userData = TheDataObtainedInTheUserQuery.are().answeredBy(theActorInTheSpotlight()).getData();
        theActorInTheSpotlight().should(
                seeThat("el id del usuario", act -> userData.getId(), equalTo(id))
                .orComplainWith(ConsultUserException.class, ID_MESSAGE_EXCEPTION),
                seeThat("el email del usuario", act -> userData.getEmail(), equalTo(email))
                        .orComplainWith(ConsultUserException.class, EMAIL_MESSAGE_EXCEPTION)
        );
    }

}
