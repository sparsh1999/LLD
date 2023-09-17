package org.example.chess.model;

public class Queen extends Peice{
    @Override
    public boolean canMove(int x, int y) {
        return ( Math.abs(this.x-x)==Math.abs(this.y-y) )|| (this.x-x==0 || this.y-y==0);
    }
}
