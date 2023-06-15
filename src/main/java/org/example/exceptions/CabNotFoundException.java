package org.example.exceptions;

public class CabNotFoundException extends RuntimeException{

    CabNotFoundException(){}
    public CabNotFoundException(String cabId) {
        super(String.format("No Cab Found For Given Id: %s", cabId));
    }
}
