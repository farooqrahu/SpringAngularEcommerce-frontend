package com.rahu.springjwt.exception;

public class WrongFilterException extends RuntimeException {

    private static final long serialVersionUID = 4161427932319403537L;

    public WrongFilterException(String msg) {
        super(msg);
    }

}
