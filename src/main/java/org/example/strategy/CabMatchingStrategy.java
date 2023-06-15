package org.example.strategy;

import org.example.models.Cab;

import java.util.List;

public interface CabMatchingStrategy {
    Cab pickCab(List<Cab> availableCabs);
}
