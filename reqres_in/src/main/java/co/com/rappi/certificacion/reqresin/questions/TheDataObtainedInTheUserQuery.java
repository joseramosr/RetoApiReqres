package co.com.rappi.certificacion.reqresin.questions;

import co.com.rappi.certificacion.reqresin.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheDataObtainedInTheUserQuery implements Question<User>{

	@Override
	public User answeredBy(Actor actor) {
		return SerenityRest.lastResponse().as(User.class);
	}
	
	public static TheDataObtainedInTheUserQuery are() {
		return new TheDataObtainedInTheUserQuery();
	}
}
