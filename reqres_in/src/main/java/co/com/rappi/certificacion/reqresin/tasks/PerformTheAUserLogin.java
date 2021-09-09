package co.com.rappi.certificacion.reqresin.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PerformTheAUserLogin implements Task {

    private String body;

    public PerformTheAUserLogin(String body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/login").with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(body))
        );
    }

    public static Performable withCredentials(String body){
        return Tasks.instrumented(PerformTheAUserLogin.class, body);
    }
}
