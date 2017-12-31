package com.brauner.advent.day22;

import com.brauner.advent.Direction;

/**
 * Created by douglas on 31/12/2017.
 */
public class EvolvedSporificaVirus extends SporificaVirus {

    public void makeMove() {

        switch (grid.get(xFactor,yFactor)) {
            case '.':
                turnLeft();
                grid.map.get(grid.x).set(grid.y, 'W');
                break;
            case 'W':
                grid.map.get(grid.x).set(grid.y, '#');
                grid.infected++;
                break;
            case '#':
                turnRight();
                grid.map.get(grid.x).set(grid.y, 'F');
                break;
            case 'F':
                grid.map.get(grid.x).set(grid.y, '.');
                turnBackwards();
                break;
        }
    }

    private void turnBackwards() {
        switch (face) {
            case UP:
                face = Direction.DOWN;
                break;
            case LEFT:
                face = Direction.RIGHT;
                break;
            case DOWN:
                face = Direction.UP;
                break;
            case RIGHT:
                face = Direction.LEFT;
                break;
        }
    }
}
