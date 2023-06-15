package org.example.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Location {
    double MAX_DISTANCE = 10.0;

    double coordX;
    double coordY;

    public Location(double x, double y) {
        this.coordX = x;
        this.coordY = y;
    }

    public boolean isReachable(Location l){
        double distance = Math.sqrt(Math.pow(l.coordX - coordX, 2)+Math.pow(l.coordY-coordY,2));
        return distance<=MAX_DISTANCE;
    }


}
