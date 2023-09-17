package org.example.chess.model;

import lombok.Data;

@Data
public abstract class Peice {
    boolean isWhite;
    boolean isAlive;
    int x;
    int y;

    public abstract boolean canMove(int x, int y);

    public void updateLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
