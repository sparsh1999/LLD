package org.example.manager;

import org.example.exceptions.CabNotFoundException;
import org.example.exceptions.NoCabAvailableException;
import org.example.models.Cab;
import org.example.models.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabManager {
    //TODO find any use of riderManager
    private RiderManager riderManager;
    private Map<String , Cab> cabMap;

    public CabManager(RiderManager riderManager) {
        this.riderManager = riderManager;
        this.cabMap = new HashMap<>();
    }

    public void registerCab(String id, double x, double y) {
        Cab cab = new Cab(id, new Location(x,y));
        cabMap.put(id, cab);
    }

    public void updateCabAvailability(String cabId, boolean isAvailable) {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException(cabId);
        }
        Cab cab = cabMap.get(cabId);
        cab.updateAvaialbility(isAvailable);
    }

    public void updateCabLocation(String cabId, double x, double y) {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException(cabId);
        }
        Cab cab = cabMap.get(cabId);
        Location newLocation = new Location(x, y);
        cab.updateLocation(newLocation);
    }

    public List<Cab> getAvailableCabs(Location fromLoc) {
        List<Cab> availableCabs = cabMap.values().stream()
                .filter(Cab::isAvailable)
                .filter(cab -> cab.getLocation().isReachable(fromLoc))
                .collect(Collectors.toList());
        if (availableCabs.size()==0) {
            throw new NoCabAvailableException();
        }
        return availableCabs;
    }

}
