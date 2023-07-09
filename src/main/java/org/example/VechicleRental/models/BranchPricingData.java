package org.example.VechicleRental.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BranchPricingData {
    String branchId;
    VechicleType vechicleType;
    double price;
}
