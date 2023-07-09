package org.example.VechicleRental.strategy;

import org.example.VechicleRental.helpers.PickedVechicle;
import org.example.VechicleRental.models.Vechicle;
import org.example.VechicleRental.models.VechicleType;

public interface VechiclePickingStrategy {
    PickedVechicle pickVechicle(VechicleType vechicleType, long startTime, long endTime);
}
