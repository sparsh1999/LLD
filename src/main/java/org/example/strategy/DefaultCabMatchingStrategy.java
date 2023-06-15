package org.example.strategy;

import org.example.exceptions.NoCabAvailableException;
import org.example.models.Cab;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{
    @Override
    public Cab pickCab(List<Cab> availableCabs) {
        if (availableCabs.size() ==0){
            throw new NoCabAvailableException();
        }
        return availableCabs.get(0);
    }
}
