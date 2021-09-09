package co.com.rappi.certificacion.reqresin.exceptions;

public class RegisterUserException extends AssertionError{

	public static final String USER_REGISTER_MESSAGE_EXCEPTION = "USER REGISTRATION WAS NOT PERFORMED";

	public RegisterUserException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
