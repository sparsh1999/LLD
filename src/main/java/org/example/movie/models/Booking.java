package org.example.movie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Booking {
    String id;
    String userId;
    Show show;
    List<Seat> bookedSeats;
    BookingStatus bookingStatus;
}
