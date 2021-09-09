package co.com.rappi.certificacion.reqresin.exceptions;

public class LoginException extends AssertionError{

	public static final String LOGIN_MESSAGE_EXCEPTION = "THE CORRECT TOKEN WAS NOT GENERATED";

	public LoginException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
