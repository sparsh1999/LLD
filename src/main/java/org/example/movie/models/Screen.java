package org.example.movie.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
    String id;
    int totalSeats;
    List<Seat> seats;

    public Screen(String id, int totalSeats) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}
