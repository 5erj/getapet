package error;

public class ErrorResponseBody {
	private String message;
	
	ErrorResponseBody(){}

	public ErrorResponseBody(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
