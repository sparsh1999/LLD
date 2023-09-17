package org.example.chess.model;

import lombok.NoArgsConstructor;
import org.example.chess.exception.InvalidMoveException;

import java.util.List;
import java.util.Optional;


@NoArgsConstructor
public class Board {
    Spot[][] spots;
    int row, col;
    List<Peice> peices;

    public Spot getSpot(int x, int y) {
        if (isValidSpot(x, y)){
            return spots[x][y];
        }
        return null;
    }

    public Board(int rows, int cols){
        this.row = rows;
        this.col = cols;
    }
    public void resetBoard() {
        spots = new Spot[row][col];
        // init various spots;
    }

    public boolean isPeicesAlive(boolean isWhite) {
        return peices.stream().filter(peice -> peice.isWhite==isWhite).anyMatch(peice -> peice.isAlive);
    }

    public boolean isValidSpot(int x, int y){
        if (x<0 || y<0 || x>=row || y>=col){
            throw new InvalidMoveException();
        }
        return true;
    }

    public void makeMove(Spot source, Spot target,Move move) {
        Peice sourcePeice = source.getPeice();
        Peice targetPeice = target.getPeice();
        if (sourcePeice.canMove(target.getX(), target.getY())) {
            if (targetPeice!=null){
                // check if target peice is of same color
                if (targetPeice.isWhite() !=sourcePeice.isWhite()) {
                    targetPeice.setAlive(false);
                    target.emptySpot();
                    source.emptySpot();
                    target.setPeice(sourcePeice);
                    move.setPeiceKilled(targetPeice);
                    move.setPeiceMoved(sourcePeice);
                }
                else{
                    throw new InvalidMoveException();
                }
            }
            else{
                // empty move
                source.emptySpot();
                target.setPeice(sourcePeice);
            }
        } else {
            throw new InvalidMoveException();
        }
    }
}
