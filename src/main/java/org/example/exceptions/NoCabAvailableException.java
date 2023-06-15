package org.example.exceptions;

public class NoCabAvailableException extends RuntimeException{
    public NoCabAvailableException() {
        super("No Cab Found For Given Trip");
    }
}
