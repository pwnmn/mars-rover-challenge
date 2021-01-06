package com.github.pwnmn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {
    @Test
    void getNextLOrientation_North_success() {
        assertEquals(Orientation.WEST, Orientation.getNextLOrientation(Orientation.NORTH));
    }

    @Test
    void getNextLOrientation_East_success() {
        assertEquals(Orientation.NORTH, Orientation.getNextLOrientation(Orientation.EAST));
    }

    @Test
    void getNextLOrientation_West_success() {
        assertEquals(Orientation.SOUTH, Orientation.getNextLOrientation(Orientation.WEST));
    }

    @Test
    void getNextLOrientation_South_success() {
        assertEquals(Orientation.SOUTH, Orientation.getNextLOrientation(Orientation.WEST));
    }

    @Test
    void getNextROrientation_North_success() {
        assertEquals(Orientation.EAST, Orientation.getNextROrientation(Orientation.NORTH));
    }

    @Test
    void getNextROrientation_East_success() {
        assertEquals(Orientation.SOUTH, Orientation.getNextROrientation(Orientation.EAST));
    }

    @Test
    void getNextROrientation_West_success() {
        assertEquals(Orientation.NORTH, Orientation.getNextROrientation(Orientation.WEST));
    }

    @Test
    void getNextROrientation_South_success() {
        assertEquals(Orientation.WEST, Orientation.getNextROrientation(Orientation.SOUTH));
    }
}
