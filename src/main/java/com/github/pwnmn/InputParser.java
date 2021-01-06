package com.github.pwnmn;

import java.util.Scanner;

public class InputParser {

    public static void initializeGame() {
        Scanner scanner = new Scanner(System.in);
        Grid grid = parseGrid(scanner.nextLine());

        while(scanner.hasNextLine()) {
            var initialPosition = parseInitialPosition(scanner.nextLine());

            String moves = scanner.nextLine();
            var interpretedMoves = Move.interpretMoves(moves);

            var rover = new Rover(initialPosition, grid);
            rover.executeMoves(interpretedMoves);
            var endPosition = rover.getPosition();
            System.out.println(endPosition.getX() + " " + endPosition.getY() + " " + endPosition.getOrientation().toString());
        }
    }

    public static Grid parseGrid(String grid) {
        String[] boundaries = grid.split(" ");
        return new Grid(Integer.valueOf(boundaries[0]), Integer.valueOf(boundaries[1]));
    }

    public static Position parseInitialPosition(String positionString) {
        var initialPosition = positionString.split(" ");
        var x = Integer.valueOf(initialPosition[0]);
        var y = Integer.valueOf(initialPosition[1]);
        var orientation = Orientation.valueOfOrientation(initialPosition[2]);
        return new Position(x, y, orientation);
    }
}
