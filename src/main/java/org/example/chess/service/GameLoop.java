package org.example.chess.service;

import org.example.chess.exception.InvalidMoveException;
import org.example.chess.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameLoop {
    Board board;
    List<Player> players;
    int activePlayerIndex;
    Player currentPlayer;
    List<Move> moves;

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void init(Player player1, Player player2, int rows, int cols){
        this.addPlayer(player1);
        this.addPlayer(player2);
        board = new Board(rows, cols);
        board.resetBoard();
        moves = new ArrayList<>();
        currentPlayer = this.players.get(0);
    }

    public void takeTurn(Player player, int x, int y, int targetX, int targetY){
        Spot source = board.getSpot(x, y);
        Spot target = board.getSpot(targetX, targetY);
        Move move = new Move(player, source, target);
        if (source==null || target == null ){
            return;
        }
        if (player==currentPlayer) {
            board.makeMove(source, target, move);
        }
        moves.add(move);

        if (this.currentPlayer == players.get(0)){
            this.currentPlayer = players.get(1);
        }
        else{
            this.currentPlayer = players.get(0);
        }
    }
}
