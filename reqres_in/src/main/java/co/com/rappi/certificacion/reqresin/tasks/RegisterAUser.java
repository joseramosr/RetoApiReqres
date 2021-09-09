package co.com.rappi.certificacion.reqresin.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class RegisterAUser implements Task {

    private String body;

    public RegisterAUser(String body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register/").with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(body))
        );
    }

    public static Performable withTheData(String body){
        return Tasks.instrumented(RegisterAUser.class, body);
    }
}
