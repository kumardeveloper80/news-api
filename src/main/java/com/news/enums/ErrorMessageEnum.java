package com.news.enums;

/**
 * @author 
 *
 * Error codes and messages
 */
public enum ErrorMessageEnum {

    APP001("News Not Found"),;
	private String value;

	ErrorMessageEnum(String error) {
		this.value = error;
	}

	public String value() {
		return value;
	}
}
