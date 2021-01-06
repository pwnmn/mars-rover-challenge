package com.github.pwnmn;

public enum Orientation {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private String value;

    Orientation(String value) {
        this.value = value;
    }

    public static Orientation valueOfOrientation(String label) {
        for (Orientation e : values()) {
            if (e.value.equals(label)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Enum value not found");
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static Orientation getNextLOrientation(Orientation orientation) {
        switch(orientation) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }

    public static Orientation getNextROrientation(Orientation orientation) {
        switch(orientation) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }
}
