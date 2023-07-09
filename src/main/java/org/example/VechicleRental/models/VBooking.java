package org.example.VechicleRental.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VBooking {
    String id;
    Vechicle vechicle;
    long fromTime;
    long toTime;
    double price;
    String branchId;
}
