package net.dao;

public class DBException extends Exception {

	private final static  long serialVersionUID = 1L;
	private String message;

	public DBException(String string) {
		message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}			