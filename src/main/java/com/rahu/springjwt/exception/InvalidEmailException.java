package com.rahu.springjwt.exception;

public class InvalidEmailException extends RuntimeException {
    public final int code;
    public final String message;
    /**
     * unique identifer for the serializable class
     */
    private static final long serialVersionUID = 8957077992146258660L;


    public InvalidEmailException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
