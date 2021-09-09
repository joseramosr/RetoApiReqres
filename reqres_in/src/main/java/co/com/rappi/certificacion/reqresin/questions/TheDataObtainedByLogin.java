package co.com.rappi.certificacion.reqresin.questions;

import co.com.rappi.certificacion.reqresin.models.LoginData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheDataObtainedByLogin implements Question<LoginData>{

	@Override
	public LoginData answeredBy(Actor actor) {
		return SerenityRest.lastResponse().as(LoginData.class);
	}
	
	public static TheDataObtainedByLogin is() {
		return new TheDataObtainedByLogin();
	}
}
