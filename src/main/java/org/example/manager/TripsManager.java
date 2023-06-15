package org.example.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.models.Cab;
import org.example.models.Location;
import org.example.models.Trip;
import org.example.strategy.CabMatchingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class TripsManager {
    CabManager cabManager;
    RiderManager riderManager;
    CabMatchingStrategy cabMatchingStrategy;
    PricingStrategy pricingStrategy;
    Map<String, Trip> tripMap;

    public TripsManager(CabManager cabManager,
                        RiderManager riderManager,
                        CabMatchingStrategy cabMatchingStrategy) {
        this.cabManager = cabManager;
        this.riderManager = riderManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.tripMap = new HashMap<>();
    }

    public void bookTrip(String id, double riderX, double riderY, double destX, double destY) {
        Location riderLoc = new Location(riderX, riderY);
        Location riderDesLoc = new Location(destX, destY);
        // get all cabs which are available
        List<Cab> availableCabs = cabManager.getAvailableCabs(riderLoc);
        // find one cab based on some criteria
        Cab cab = cabMatchingStrategy.pickCab(availableCabs);
        double price = 0.0;
        // create a trip
        // calculate the price
        Trip trip = new Trip(id, cab,riderLoc, riderDesLoc, price);
        // disable that cab
        cab.updateAvaialbility(false);
    }

}
