package co.com.rappi.certificacion.reqresin.exceptions;

public class ConsultUserException extends AssertionError{

	public static final String SUCCESSFUL_RESPONSE_CODE_MESSAGE_EXCEPTION = "ERROR, THE RESPONSE CODE DOES NOT MATCH THE EXPECTED";
	public static final String ID_MESSAGE_EXCEPTION = "THE ID DOES NOT MATCH THE ONE OF THE SEARCHED USER";
	public static final String EMAIL_MESSAGE_EXCEPTION = "THE EMAIL DOES NOT MATCH THE ONE OF THE SEARCHED USER";

	public ConsultUserException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
