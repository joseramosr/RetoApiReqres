package co.com.rappi.certificacion.reqresin.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultAUser implements Task {

    private int id;

    public ConsultAUser(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users/{id}")
                        .with(requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .pathParam("id", id))
        );
    }

    public static Performable byId(int id){
        return Tasks.instrumented(ConsultAUser.class, id);
    }
}
