package com.epam.task03.lib.exception;

/**
 * Created by Yauheni_Borbut on 2/1/2017.
 */
public class InitializationException extends Exception {

    public InitializationException() {
        super();
    }

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(String message, Exception e) {
        super(message, e);
    }

    public InitializationException(Exception e) {
        super(e);
    }
}
