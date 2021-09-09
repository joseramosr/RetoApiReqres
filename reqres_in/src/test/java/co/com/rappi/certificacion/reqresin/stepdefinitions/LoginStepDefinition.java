package co.com.rappi.certificacion.reqresin.stepdefinitions;

import static co.com.rappi.certificacion.reqresin.exceptions.LoginException.*;

import co.com.rappi.certificacion.reqresin.exceptions.LoginException;
import co.com.rappi.certificacion.reqresin.models.LoginData;
import co.com.rappi.certificacion.reqresin.questions.TheDataObtainedByLogin;
import co.com.rappi.certificacion.reqresin.tasks.PerformTheAUserLogin;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinition {

    @When("^he performs the login of a user with the credentials (.*)$")
    public void hePerformsTheLoginOfAUserWithTheCredentials(String body) {
        theActorInTheSpotlight().attemptsTo(PerformTheAUserLogin.withCredentials(body));
    }

    @And("^that the successful login response contains the token (.*) field$")
    public void thatTheSuccessfulLoginResponseContainsTheTokenField(String token) {
        LoginData loginData = TheDataObtainedByLogin.is().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().should(
                seeThat("el token del usuario", act -> loginData.getToken(), equalTo(token))
                        .orComplainWith(LoginException.class, LOGIN_MESSAGE_EXCEPTION)
        );
    }
}
