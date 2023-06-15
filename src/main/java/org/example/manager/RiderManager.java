package org.example.manager;

import org.example.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    Map<String, Rider> riderMap;

    public RiderManager() {
        riderMap = new HashMap<>();
    }

    public void createRider(String id, String name) {
        Rider rider = new Rider(id, name);
        riderMap.put(rider.getId(), rider);
    }
}
