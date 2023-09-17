package org.example.chess.model;

public class Knight extends Peice{
    @Override
    public boolean canMove(int x, int y) {
        return Math.abs(this.x - x)<=2 && Math.abs(this.y - y)<=2;
    }
}
