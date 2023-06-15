package org.example.movie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SeatLock {
    Seat seat;
    long fromTs;
    long duration;


    public boolean isLockValid() {
        long currTs = System.currentTimeMillis();
        return currTs < fromTs + duration;
    }
}
