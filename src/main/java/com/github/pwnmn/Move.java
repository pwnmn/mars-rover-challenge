package com.github.pwnmn;

import java.util.ArrayList;
import java.util.List;

public enum Move {
    LEFT("L"), MOVE("M"), RIGHT("R");

    String move;

    Move(String move) {
        this.move = move;
    }

    public static List<Move> interpretMoves(String moves) {
        var moveList = new ArrayList<Move>();
        for(int i=0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'L':
                    moveList.add(Move.LEFT);
                    break;
                case 'M':
                    moveList.add(Move.MOVE);
                    break;
                case 'R':
                    moveList.add(Move.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown move");
            }
        }
        return moveList;
    }
}
