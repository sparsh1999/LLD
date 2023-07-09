package org.example.VechicleRental.service;

import org.example.VechicleRental.exception.VechicleNotFoundException;
import org.example.VechicleRental.models.Vechicle;

import java.util.Map;

public class VechicleService {
    Map<String, Vechicle> carMap;

    public boolean containsVechicle(String vechicleId){
        if (carMap.containsKey(vechicleId)){
            return true;
        }
        return false;
    }

    public Vechicle getVechicle(String vechicleId){
        if (!carMap.containsKey(vechicleId)) {
            throw new VechicleNotFoundException(vechicleId);
        }
        return carMap.get(vechicleId);
    }
}
