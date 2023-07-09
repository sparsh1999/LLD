package org.example.VechicleRental.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Branch {
    String branchName;
    String id;
    String city;
    String pincode;
    String address;

    public Branch(String id, String branchName){
        this.id = id;
        this.branchName = branchName;
    }
}
