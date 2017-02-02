package com.epam.task03.lib.exception;

/**
 * Created by Yauheni_Borbut on 2/1/2017.
 */
public class ParseException extends Exception {

    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Exception e) {
        super(message, e);
    }

    public ParseException(Exception e) {
        super(e);
    }
}
