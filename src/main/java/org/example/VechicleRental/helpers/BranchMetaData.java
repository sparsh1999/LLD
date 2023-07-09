package org.example.VechicleRental.helpers;

import org.example.VechicleRental.models.Branch;
import org.example.VechicleRental.models.Vechicle;
import org.example.VechicleRental.models.VechicleType;

import java.util.*;
import java.util.stream.Collectors;

public class BranchMetaData {
    public Branch branch;
    public Map<VechicleType, Double> vechilePricingMap = new HashMap<>();
    Map<VechicleType, List<Vechicle>> vechicleMap = new HashMap<>();

    public BranchMetaData(Branch branch) {
        this.branch = branch;
    }

    public void addVechiclePricingInfo(VechicleType vechicleType, double price) {
        vechilePricingMap.put(vechicleType, price);
    }

    public void addVechicle(Vechicle vechicle){
        VechicleType vechicleType = vechicle.getVechicleType();
        List<Vechicle> vechicles = vechicleMap.getOrDefault(vechicleType, new ArrayList<>());
        boolean alreadyExist = vechicles.stream().anyMatch(vech -> vech.getId().equals(vechicle.getId()));
        if (alreadyExist) {
            // ignoring request
        }
        vechicles.add(vechicle);
        vechicleMap.put(vechicleType, vechicles);
    }

    public List<Vechicle> getAllVechicles() {
        return vechicleMap.values()
                .stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
