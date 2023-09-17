package org.example.chess.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spot {
    Peice peice;
    int x, y;

    public void emptySpot(){
        this.peice = null;
    }
}
