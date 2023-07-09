package org.example.VechicleRental.service;

import org.example.VechicleRental.helpers.BranchMetaData;
import org.example.VechicleRental.helpers.PickedVechicle;
import org.example.VechicleRental.models.Vechicle;
import org.example.VechicleRental.models.VechicleType;
import org.example.VechicleRental.models.VBooking;
import org.example.VechicleRental.strategy.VechiclePickingStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingService {
    Map<String, VBooking> bookingMap;
    Map<String, List<VBooking>> vechicleBookingMap;
    BranchService branchService;
    VechiclePickingStrategy vechiclePickingStrategy;

    public boolean isVechicleBooked(Vechicle vechicle, long startTime, long endTime) {
        return vechicleBookingMap.get(vechicle.getId()).stream()
                .noneMatch(booking -> startTime<=booking.getFromTime() && booking.getToTime()<=endTime);
    }
    public void bookVechicle(VechicleType vechicleType, long startTime, long endTime) {
        PickedVechicle pickedVechicle = vechiclePickingStrategy.pickVechicle(vechicleType, startTime, endTime);
        BranchMetaData branchMetaData = branchService.getBranchInfo(pickedVechicle.getBranchId());
        double priceOfPickedVechiclePerHour = branchMetaData.vechilePricingMap.get(vechicleType);
        double finalPrice = priceOfPickedVechiclePerHour*((endTime-startTime)/216000);
        String bookingId = UUID.randomUUID().toString();
        bookingMap.put(bookingId, new VBooking(bookingId, pickedVechicle.getVechicle(),startTime, endTime, finalPrice, pickedVechicle.getBranchId()));
    }

    public List<Vechicle> getBookedVechicles(long fromTime, long toTime){
        return bookingMap.values().stream().filter(booking ->
                // this is wrong correct it
                !(booking.getFromTime() >= toTime)
        ).map(VBooking::getVechicle).collect(Collectors.toList());
    }
}
