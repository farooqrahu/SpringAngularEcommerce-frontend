package com.rahu.springjwt.exception;

public class ExceptionWithMessage extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3524518909548950819L;

    public ExceptionWithMessage(String object) {
        super(object);
    }
}
