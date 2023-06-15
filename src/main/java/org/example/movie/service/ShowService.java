package org.example.movie.service;

import org.example.movie.models.Seat;
import org.example.movie.models.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowService {
    Map<String, Show> showMap;
    BookingService bookingService;
    SeatLockService seatLockService;

    public ShowService (BookingService bookingService) {
        this.bookingService = bookingService;
        this.showMap = new HashMap<>();
    }

    public List<Seat> getUnAvailableSeats(String showId) {
        Show show = showMap.get(showId);
        List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> unavailableSeats = new ArrayList<>();
        unavailableSeats.addAll(bookingService.getBookedSeats(show));
        unavailableSeats.addAll(seatLockService.getLockedSeats(show));

    }

    public List<Seat> getUnavailableSeats() {

    }
}
