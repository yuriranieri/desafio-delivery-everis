package br.com.delivery.config.validation;

public class ErrorForm {
	
	private String field;
	private String error;

	public ErrorForm(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getCampo() {
		return field;
	}

	public String getError() {
		return error;
	}

}
