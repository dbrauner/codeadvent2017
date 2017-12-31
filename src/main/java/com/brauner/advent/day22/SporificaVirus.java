package com.brauner.advent.day22;

import com.brauner.advent.Direction;

import java.util.LinkedList;

/**
 * Created by douglas on 31/12/2017.
 */
public class SporificaVirus {

    GridLinked grid = new GridLinked();

    int LOOPS = 10000;
    int xFactor;
    int yFactor;

    Direction face;

    public void runMap(String input) {

        String[] lines = input.split("\\n");

        grid = new GridLinked();
        for (String line : lines) {
            grid.map.add(new LinkedList<>());
            char[] points = line.toCharArray();
            for (char point : points) {
                grid.map.getLast().add(point);
            }
        }
        int halfway = (grid.map.size() / 2);
        grid.x = grid.y = halfway;
        grid.infected = 0;
        grid.currentSize = grid.map.size();
        face = Direction.UP;

        xFactor = 0;
        yFactor = 0;
        for (int i = 0; i < LOOPS; i++) {
            makeMove();
            switch (face) {
                case UP:
                    xFactor = -1;
                    yFactor = 0;
                    break;
                case LEFT:
                    xFactor = 0;
                    yFactor = -1;
                    break;
                case DOWN:
                    xFactor = +1;
                    yFactor = 0;
                    break;
                case RIGHT:
                    xFactor = 0;
                    yFactor = 1;
                    break;
            }
        }
        grid.print(0, 0);

    }

    public void makeMove() {
        // grid.print(xFactor, yFactor);
        if (grid.get(xFactor,yFactor) == '.') {
            turnLeft();
            grid.map.get(grid.x).set(grid.y, '#');
            grid.infected++;
        } else {
            turnRight();
            grid.map.get(grid.x).set(grid.y, '.');
        }
    }

    public void turnRight() {
        switch (face) {
            case UP:
                face = Direction.RIGHT;
                break;
            case LEFT:
                face = Direction.UP;
                break;
            case DOWN:
                face = Direction.LEFT;
                break;
            case RIGHT:
                face = Direction.DOWN;
                break;
        }
    }

    public void turnLeft() {
        switch (face) {
            case UP:
                face = Direction.LEFT;
                break;
            case LEFT:
                face = Direction.DOWN;
                break;
            case DOWN:
                face = Direction.RIGHT;
                break;
            case RIGHT:
                face = Direction.UP;
                break;
        }

    }

}
