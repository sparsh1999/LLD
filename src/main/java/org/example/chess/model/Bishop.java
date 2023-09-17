package org.example.chess.model;

public class Bishop extends Peice{
    @Override
    public boolean canMove(int x, int y) {
        return Math.abs(this.x-x)==Math.abs(this.y-y);
    }
}
