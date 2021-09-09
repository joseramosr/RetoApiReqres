package co.com.rappi.certificacion.reqresin.stepdefinitions;

import static co.com.rappi.certificacion.reqresin.exceptions.RegisterUserException.*;

import co.com.rappi.certificacion.reqresin.exceptions.RegisterUserException;
import co.com.rappi.certificacion.reqresin.models.RegisterData;
import co.com.rappi.certificacion.reqresin.questions.TheDataObtainedByTheUserRegistration;
import co.com.rappi.certificacion.reqresin.tasks.RegisterAUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDefinition {

    @When("^he performs the register of a user with the data (.*)$")
    public void hePerformsTheRegisterOfAUserWithTheData(String body) {
        theActorInTheSpotlight().attemptsTo(RegisterAUser.withTheData(body));
    }

    @And("^that the successful registration response contains the id (.*) and token (.*) fields$")
    public void thatTheSuccessfulRegistrationResponseContainsTheIdAndTokenFields(int id, String token) {
        RegisterData registerData = TheDataObtainedByTheUserRegistration.are().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().should(
                seeThat("el id del usuario", act -> registerData.getId(), equalTo(id))
                        .orComplainWith(RegisterUserException.class, USER_REGISTER_MESSAGE_EXCEPTION),
                seeThat("el token del usuario", act -> registerData.getToken(), equalTo(token))
                        .orComplainWith(RegisterUserException.class, USER_REGISTER_MESSAGE_EXCEPTION)
        );
    }

}
