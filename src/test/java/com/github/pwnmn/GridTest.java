package com.github.pwnmn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    public void canMove_OutsideBoundary_canNotMove() {
        Grid grid = new Grid(5, 5);
        assertFalse(grid.canMove(5, 6));
        assertFalse(grid.canMove(6, 5));
        assertFalse(grid.canMove(-1, 0));
        assertFalse(grid.canMove(0, -1));
    }

    @Test
    public void canMove_InsideBoundary_canMove() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.canMove(5, 5));
        assertTrue(grid.canMove(0, 5));
        assertTrue(grid.canMove(5, 0));
        assertTrue(grid.canMove(0, 0));
    }

    @Test
    public void instantiateRover_provideGrid_correctGrid() {
        Grid grid = new Grid(4, 5);
        assertEquals(4, grid.getxSize());
        assertEquals(5, grid.getySize());
    }
}
