package org.example.VechicleRental.strategy;

import org.example.VechicleRental.helpers.BranchMetaData;
import org.example.VechicleRental.helpers.PickedVechicle;
import org.example.VechicleRental.models.Vechicle;
import org.example.VechicleRental.models.VechicleType;
import org.example.VechicleRental.service.BookingService;

import java.util.List;
import java.util.PriorityQueue;

public class LowestRentalVechiclePickingStrategy implements VechiclePickingStrategy{
    BookingService bookingService;

    @Override
    public PickedVechicle pickVechicle(VechicleType vechicleType, long startTime, long endTime) {
        PriorityQueue<BranchMetaData> pq = new PriorityQueue<>((a,b)->{
            if (!a.vechilePricingMap.containsKey(vechicleType))
                return 1;
            return (int) (a.vechilePricingMap.get(vechicleType) - b.vechilePricingMap.get(vechicleType));
        });

        while(pq.size()>0){
            BranchMetaData branchMetaData = pq.poll();
            List<Vechicle> bookedVechicles = bookingService.getBookedVechicles(startTime, endTime);
            List<Vechicle> allVechicles = branchMetaData.getAllVechicles();
            allVechicles.removeAll(bookedVechicles);

            if (allVechicles.size()>0){
                return new PickedVechicle(allVechicles.get(0), branchMetaData.branch.getId());
            }
        }
        throw new RuntimeException("No Vechicles found to book in this slot");
    }
}
