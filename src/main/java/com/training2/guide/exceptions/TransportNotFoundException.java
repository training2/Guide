package com.training2.guide.exceptions;

/**
 * This class use to catch exception if insert of DB is wrong
 * @author rutkovba
 */
public class TransportNotFoundException extends Exception {

    public TransportNotFoundException(String message) {
        super(message);
    }
}
