package net.jdbc;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public DBException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
