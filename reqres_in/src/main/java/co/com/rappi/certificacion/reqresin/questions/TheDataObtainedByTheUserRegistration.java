package co.com.rappi.certificacion.reqresin.questions;

import co.com.rappi.certificacion.reqresin.models.RegisterData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheDataObtainedByTheUserRegistration implements Question<RegisterData>{

	@Override
	public RegisterData answeredBy(Actor actor) {
		return SerenityRest.lastResponse().as(RegisterData.class);
	}
	
	public static TheDataObtainedByTheUserRegistration are() {
		return new TheDataObtainedByTheUserRegistration();
	}
}
