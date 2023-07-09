package org.example.VechicleRental.exception;

public class VechicleNotFoundException extends RuntimeException{
    public VechicleNotFoundException() {
        super();
    }

    public VechicleNotFoundException(String vechicleId){
        super(String.format("Vechicle Not found in system with id :%s", vechicleId));
    }
}
