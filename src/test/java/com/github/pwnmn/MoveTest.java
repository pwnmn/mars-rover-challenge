package com.github.pwnmn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    @Test
    void interpretMoves_validMoves_sucessfullyInterpreted() {
        var interpretedMoves = Move.interpretMoves("LMRLMRL");
        assertEquals(Move.LEFT, interpretedMoves.get(0));
        assertEquals(Move.MOVE, interpretedMoves.get(1));
        assertEquals(Move.RIGHT, interpretedMoves.get(2));
        assertEquals(Move.LEFT, interpretedMoves.get(3));
        assertEquals(Move.MOVE, interpretedMoves.get(4));
        assertEquals(Move.RIGHT, interpretedMoves.get(5));
        assertEquals(Move.LEFT, interpretedMoves.get(6));
    }

    @Test
    void interpretMoves_invalidMoves_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Move.interpretMoves("A"));
    }
}
