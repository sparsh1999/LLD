package org.example.movie.service;

import org.example.movie.models.Seat;
import org.example.movie.models.SeatLock;
import org.example.movie.models.Show;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeatLockService {
    //screen vs locked seats
    Map<String, List<SeatLock>> seatLockMap;

    public List<Seat> getLockedSeats(Show show) {
        return seatLockMap.values().stream()
                .map(x -> x.stream()
                        .filter(SeatLock::isLockValid)
                        .map(SeatLock::getSeat)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
