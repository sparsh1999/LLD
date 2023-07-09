package org.example.VechicleRental.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vechicle {
    String id;
    VechicleType vechicleType;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vechicle))
            return false;
        Vechicle otherVech = (Vechicle) obj;

        return otherVech.id.equals(this.id);
    }
}
