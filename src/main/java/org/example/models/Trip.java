package org.example.models;

import lombok.AllArgsConstructor;

public class Trip {
    String id;
    Cab cab;
    TripStatus tripStatus;
    Location fromSrc;
    Location toDest;
    double price;

    public Trip(String id, Cab cab, Location fromSrc, Location toDest, double price) {
        this.id = id;
        this.cab = cab;
        this.tripStatus = TripStatus.IN_PROGRESS;
        this.fromSrc = fromSrc;
        this.toDest = toDest;
        this.price = price;
    }
}
