package org.example.models;

import lombok.Getter;

@Getter
public class Cab {
    String id;
    Location location;
    boolean available;

    public Cab(String id, Location location){
        this.id = id;
        this.location = location;
        this.available = true;
    }
    public void updateAvaialbility(boolean isAvailable) {
        this.available = isAvailable;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }
}
