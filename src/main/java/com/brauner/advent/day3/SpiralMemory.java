package com.brauner.advent.day3;

/**
 * Created by douglas on 08/12/2017.
 */
public class SpiralMemory {

    private static int SPIRAL_SIZE = 1024;

    int[][] stressSpiral = new int[SPIRAL_SIZE][SPIRAL_SIZE];

    private Direction direction = Direction.RIGHT;

    private int steps = 0;
    private int maxSteps = 1;

    public int calculateTaxicabDistance(int input) {

        int distance = 0;
        int rows = 0;
        int columns = 0;
        int[][] spiral = createSpiralList();
        Position positionInput = getPositionInSpiral(spiral, input);
        Position positionInitial = getPositionInSpiral(spiral, 1);
        int differenceX = Math.abs(positionInput.getX() - positionInitial.getX());
        int differenceY = Math.abs(positionInput.getY() - positionInitial.getY());
        distance = differenceX + differenceY;

        return distance;
    }

    public int calculateFirstLargerValueInStressedSpiral(int input) {
        int[][] baseSpiral = createSpiralList();
        Position positionInitial = getPositionInSpiral(baseSpiral, 1);
        stressSpiral[positionInitial.getX()][positionInitial.getY()] = 1;
        Position currentPosition = positionInitial;
        while (true) {
            Position nextPosition = walk(currentPosition);

            stressSpiral[nextPosition.getX()][nextPosition.getY()] = sumAdjacent(nextPosition);
            System.out.println("x=" + nextPosition.getX() + " y=" + nextPosition.getY() +
            " valor=" + stressSpiral[nextPosition.getX()][nextPosition.getY()]);
            if (stressSpiral[nextPosition.getX()][nextPosition.getY()] > input)
                    return stressSpiral[nextPosition.getX()][nextPosition.getY()];
            currentPosition.setX(nextPosition.getX());
            currentPosition.setY(nextPosition.getY());
        }
    }

    private int sumAdjacent(Position position){
        int result = 0;
        int x = position.getX();
        int y = position.getY();
        result += stressSpiral[x][y] + stressSpiral[x-1][y];
        result += stressSpiral[x][y] + stressSpiral[x-1][y+1];
        result += stressSpiral[x][y] + stressSpiral[x][y+1];
        result += stressSpiral[x][y] + stressSpiral[x+1][y+1];
        result += stressSpiral[x][y] + stressSpiral[x+1][y];
        result += stressSpiral[x][y] + stressSpiral[x+1][y-1];
        result += stressSpiral[x][y] + stressSpiral[x][y-1];
        result += stressSpiral[x][y] + stressSpiral[x-1][y-1];

        return result;

    }

    private Position walk(Position currentPosition) {
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        steps++;

        if (direction == Direction.RIGHT) {
            x++;
        }
        else {
            if (direction == Direction.UP) {
                y--;
            } else if (direction == Direction.LEFT) {
                x--;
            } else if (direction == Direction.DOWN) {
                y++;
            }
        }
        if (steps == maxSteps) {


            if (direction == Direction.RIGHT) {
                direction = Direction.UP;
                steps = 0;
            }
            else {
                if (direction == Direction.UP) {
                    direction = Direction.LEFT;
                    steps = 0;
                    maxSteps++;
                } else if (direction == Direction.LEFT) {
                    direction = Direction.DOWN;
                    steps = 0;
                } else if (direction == Direction.DOWN) {
                    direction = Direction.RIGHT;
                    steps = 0;
                    maxSteps++;
                }
            }

        }

        return new Position(x, y);
    }

    private Position getPositionInSpiral(int[][] spiral, int input) {
        Position position = new Position();
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral.length ; j++) {
                if ( spiral[i][j] == input) {
                    position.setX(i);
                    position.setY(j);
                }
            }
        }
        return position;
    }

    private int[][] createSpiralList() {
        int size = SPIRAL_SIZE;
        int[][] spiral = new int[size][size];
        int value = 1;
        int minCol = 0;
        int maxCol = size-1;
        int minRow = 0;
        int maxRow = size-1;

        while (value <= size*size)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                spiral[minRow][i] = value;
                value++;
            }
            for (int i = minRow+1; i <= maxRow; i++)
            {
                spiral[i][maxCol] = value;
                value++;
            }
            for (int i = maxCol-1; i >= minCol; i--)
            {
                spiral[maxRow][i] = value;
                value++;
            }
            for (int i = maxRow-1; i >= minRow+1; i--)
            {
                spiral[i][minCol] = value;
                value++;
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral.length ; j++) {
                spiral[i][j] = value - spiral[i][j];
            }
        }
        return spiral;
    }
}
