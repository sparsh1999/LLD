package org.example.chess.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class Move {
    Player player;
    Spot source;
    Spot target;
    Peice peiceMoved;
    Peice peiceKilled;

    public Move(Player player, Spot source, Spot target){
        this.player = player;
        this.source = source;
        this.target = target;
    }

}
