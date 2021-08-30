package com.news.exception;


/**
 * @author 
 *
 * Custom Exception class for com.WeatherChallengeException.
 */
public class NewsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessge;

    private String errorCode;


    public NewsException(String errorCode, String errorMessge) {
        this.errorCode = errorCode;
        this.errorMessge = errorMessge;
    }

    public NewsException(String s, String errorMessge, String errorCode) {
        super(s);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public NewsException(String s, Throwable throwable, String errorMessge, String errorCode) {
        super(s, throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public NewsException(Throwable throwable, String errorMessge, String errorCode) {
        super(throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public NewsException(Throwable e) {
        super(e);
    }



    public String getErrorMessge() {
        return errorMessge;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
