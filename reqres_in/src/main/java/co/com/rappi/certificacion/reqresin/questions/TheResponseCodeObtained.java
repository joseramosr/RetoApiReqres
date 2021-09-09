package co.com.rappi.certificacion.reqresin.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResponseCodeObtained implements Question<Integer>{

	@Override
	public Integer answeredBy(Actor actor) {
		return SerenityRest.lastResponse().statusCode();
	}
	
	public static TheResponseCodeObtained is() {
		return new TheResponseCodeObtained();
	}
}
