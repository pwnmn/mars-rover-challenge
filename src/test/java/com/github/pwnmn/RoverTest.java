package com.github.pwnmn;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.pwnmn.Move.LEFT;
import static com.github.pwnmn.Move.MOVE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    Grid grid = new Grid(5,5);

    @Test
    void executeMoves_testTurnRight_successfullyTurned() {
        Position position = new Position(0, 0, Orientation.NORTH);
        Rover rover = new Rover(position, grid);
        rover.executeMoves(List.of(Move.RIGHT));

        assertEquals(Orientation.EAST, rover.getPosition().getOrientation());
    }

    @Test
    void executeMoves_testTurnLeft_successfullyTurned() {
        Position position = new Position(0, 0, Orientation.NORTH);
        Rover rover = new Rover(position, grid);
        rover.executeMoves(List.of(LEFT));

        assertEquals(Orientation.WEST, rover.getPosition().getOrientation());
        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());

    }

    @Test
    void executeMoves_testMove_successfullyMoved() {
        Position position = new Position(0, 0, Orientation.NORTH);
        Rover rover = new Rover(position, grid);
        rover.executeMoves(List.of(MOVE));

        assertEquals(Orientation.NORTH, rover.getPosition().getOrientation());
        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
    }

    @Test
    void executeMoves_testTurnAndMoveCombination_successfullyMoved() {
        Position position = new Position(1, 2, Orientation.NORTH);
        Rover rover = new Rover(position, grid);

        rover.executeMoves(List.of(LEFT, MOVE, LEFT, MOVE, LEFT, MOVE, LEFT, MOVE, MOVE));

        assertEquals(Orientation.NORTH, rover.getPosition().getOrientation());
        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
    }

    @Test
    void executeMoves_testIllegalMove_notMoved() {
        Position position = new Position(5, 5, Orientation.NORTH);
        Rover rover = new Rover(position, grid);
        rover.executeMoves(List.of(MOVE));

        assertEquals(Orientation.NORTH, rover.getPosition().getOrientation());
        assertEquals(5, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
    }
}
