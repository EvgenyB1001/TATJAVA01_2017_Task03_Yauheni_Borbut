package com.epam.task03.lib.dao.exception;

/**
 * Created by Yauheni_Borbut on 1/30/2017.
 */
public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }

    public DAOException(Exception e) {
        super(e);
    }
}
