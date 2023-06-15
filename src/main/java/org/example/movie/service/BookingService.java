package org.example.movie.service;

import org.example.movie.models.Booking;
import org.example.movie.models.Seat;
import org.example.movie.models.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {
    Map<String, Booking> bookingMap;
    SeatLockService seatLockService;

    public BookingService (){
        this.bookingMap = new HashMap<>();
    }

    public List<Seat> getBookedSeats(Show show) {
        return bookingMap.values().stream()
                .map(Booking::getBookedSeats)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public Booking createBooking(String userId, List<Seat> seats, Show show) {
        for (Seat seat: seats) {
            // if seat booked or
        }
    }
}
