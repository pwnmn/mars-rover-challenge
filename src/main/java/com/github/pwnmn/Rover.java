package com.github.pwnmn;

import java.util.List;

public class Rover {
    private final Grid grid;
    private Position position;

    public Rover(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
    }

    public void executeMoves(List<Move> moves) {
        moves.forEach(move -> {
            switch (move) {
                case LEFT:
                    this.turnLeft();
                    break;
                case RIGHT:
                    this.turnRight();
                    break;
                case MOVE:
                    this.move();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown move");
            }
        });
    }

    private void executeAction(Move move) {
        switch(move) {
            case LEFT:
                this.turnLeft();
                break;
            case RIGHT:
                this.turnRight();
                break;
            case MOVE:
                this.move();
                break;
            default:
                throw new IllegalArgumentException("Not a valid move");
        }
    }

    private void turnLeft() {
        var currentOrientation = this.position.getOrientation();
        this.position.setOrientation(
                currentOrientation.getNextLOrientation(currentOrientation)
        );
    }

    private void turnRight() {
        var currentOrientation = this.position.getOrientation();
        this.position.setOrientation(
                currentOrientation.getNextROrientation(currentOrientation)
        );
    }

    private void move() {
        var currentPosition = this.getPosition();
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        var orientation = currentPosition.getOrientation();

        switch(orientation) {
            case NORTH:
                if(grid.canMove(x, y + 1)) {
                    this.position = new Position(x, y+1, orientation);
                }
                break;
            case EAST:
                if(grid.canMove(x + 1, y)) {
                    this.position = new Position(x+1, y, orientation);
                }
                break;
            case WEST:
                if(grid.canMove(x - 1, y)) {
                    this.position = new Position(x-1, y, orientation);
                }
                break;
            case SOUTH:
                if(grid.canMove(x, y - 1)) {
                    this.position = new Position(x, y-1, orientation);
                }
                break;
            default:
                throw new IllegalArgumentException("Not a valid orientation");
        }
    }

    public Position getPosition() {
        return position;
    }
}
