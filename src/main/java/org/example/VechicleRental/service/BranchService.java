package org.example.VechicleRental.service;

import org.example.VechicleRental.helpers.BranchMetaData;
import org.example.VechicleRental.models.Branch;
import org.example.VechicleRental.models.BranchPricingData;
import org.example.VechicleRental.models.Vechicle;
import org.example.VechicleRental.models.VechicleType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BranchService {
    Map<String, BranchMetaData> branchMap;
    VechicleService vechicleService;
    BookingService bookingService;

    protected void addBranch(String branchId, String branchName) {
        Branch branch = new Branch(branchId, branchName);
        BranchMetaData branchMetaData = new BranchMetaData(branch);
        branchMap.put(branchId, branchMetaData);
    }

    protected void allocatePrice(String branchId, VechicleType vechicleType, double price){
        BranchMetaData branchMetaData = getBranchInfo(branchId);
        branchMetaData.addVechiclePricingInfo(vechicleType, price);
    }

    public BranchMetaData getBranchInfo(String branchId){
        if (!branchMap.containsKey(branchId)){
            throw new RuntimeException("Branch does not exist");
        }
        return branchMap.get(branchId);
    }
    protected void addVechicle(String branchId, String vechicleId){
        Vechicle vechicle = vechicleService.getVechicle(vechicleId);
        BranchMetaData branchMetaData = getBranchInfo(branchId);
        branchMetaData.addVechicle(vechicle);
    }

    public Map<String, Map<VechicleType, List<String>>> getStats(long startTime, long endTime) {
        // returns {"Not_Available": {"SUV":["a","b"], "SEDAN": ["c","d"]}}
        Map<String, Map<VechicleType, List<String>>> stats = new HashMap<>();
        List<Vechicle> bookedVechicles = bookingService.getBookedVechicles(startTime, endTime);
        List<Vechicle> allVechicles = branchMap.values().stream()
                .map(BranchMetaData::getAllVechicles)
                .flatMap(Collection::stream).collect(Collectors.toList());
        allVechicles.removeAll(bookedVechicles);

        Map<VechicleType, List<String>> bookedVechiclesMap = new HashMap<>();
        for (Vechicle vechicle: bookedVechicles){
            bookedVechiclesMap.get(vechicle.getVechicleType()).add(vechicle.getId());
        }

        Map<VechicleType, List<String>> availableVechiclesMap = new HashMap<>();
        for (Vechicle vechicle: allVechicles){
            availableVechiclesMap.get(vechicle.getVechicleType()).add(vechicle.getId());
        }

        stats.put("Not_Available", bookedVechiclesMap);
        stats.put("Available", availableVechiclesMap);

        return stats;
    }

}
