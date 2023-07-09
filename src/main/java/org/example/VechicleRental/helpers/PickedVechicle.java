package org.example.VechicleRental.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.VechicleRental.models.Vechicle;

@AllArgsConstructor
@Getter
public class PickedVechicle {
    Vechicle vechicle;
    String branchId;
}
