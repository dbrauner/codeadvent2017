package com.brauner.advent.day19;

import com.brauner.advent.Direction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TubeScreamer {

    char[][] diagram = null;
    int index;

    static int SIZE = 202;

    public String walkTubes(String path) throws IOException {

        index = 0;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(this::processInput);
        }

        try {
            return getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private void processInput(String s) {
        if (diagram == null)
            diagram = new char[SIZE][SIZE];

        char[] line = s.toCharArray();

        System.arraycopy(line, 0, diagram[index], 0, s.length());
        index++;

    }

    public String getPath() throws Exception {

        int currentX = 0;
        int currentY = 0;
        String word = "";
        int steps = 0;
        Direction direction = Direction.DOWN;
        for (int i = 0; i < SIZE; i++) {
            if (diagram[0][i] == '|') {
                currentY = i;
                break;
            }
        }

        boolean hasMore = true;

        while (hasMore) {
            if (direction.equals(Direction.DOWN)) {
                if (currentX < SIZE - 1) {
                    currentX++;
                    steps++;
                    if (diagram[currentX][currentY] == '+')
                        direction = changeDirection(direction, currentX, currentY);
                }
            }
            if (direction.equals(Direction.RIGHT)) {
                if (currentY < SIZE - 1) {
                    currentY++;
                    steps++;
                    if (diagram[currentX][currentY] == '+')
                        direction = changeDirection(direction, currentX, currentY);
                }
            }
            if (direction.equals(Direction.UP)) {
                if (currentX > 0) {
                    currentX--;
                    steps++;
                    if (diagram[currentX][currentY] == '+')
                        direction = changeDirection(direction, currentX, currentY);
                }
            }
            if (direction.equals(Direction.LEFT)) {
                if (currentY > 0) {
                    currentY--;
                    steps++;
                    if (diagram[currentX][currentY] == '+')
                        direction = changeDirection(direction, currentX, currentY);
                }
            }
            if (Character.isLetter(diagram[currentX][currentY])) {
                word += diagram[currentX][currentY];
            }
            if (diagram[currentX][currentY] == ' ' || diagram[currentX][currentY] == '\u0000')
                break;
        }

        System.out.println("walked " + steps + " steps") ;
        return word;
    }

    private Direction changeDirection(Direction direction, int currentX, int currentY) throws Exception {
        if (direction.equals(Direction.DOWN)) {
            if (currentY > 0) {
                if (diagram[currentX][currentY-1] != ' ' && diagram[currentX][currentY-1] != '\u0000')
                    return Direction.LEFT;
            }
            if (currentY < SIZE - 1) {
                if (diagram[currentX][currentY+1] != ' ' && diagram[currentX][currentY+1] != '\u0000')
                    return Direction.RIGHT;
            }
        }
        if (direction.equals(Direction.RIGHT)) {
            if (currentX < SIZE - 1) {
                if (diagram[currentX+1][currentY] != ' ' && diagram[currentX+1][currentY] != '\u0000') {
                    return Direction.DOWN;
                }
            }
            if (currentX > 0) {
                if (diagram[currentX-1][currentY ] != ' ' && diagram[currentX-1][currentY] != '\u0000')
                    return Direction.UP;
            }
        }
        if (direction.equals(Direction.UP)) {
            if (currentY > 0) {
                if (diagram[currentX][currentY-1] != ' ' && diagram[currentX][currentY-1] != '\u0000')
                    return Direction.LEFT;
            }
            if (currentY < SIZE - 1) {
                if (diagram[currentX][currentY+1] != ' ' && diagram[currentX][currentY+1] != '\u0000')
                    return Direction.RIGHT;
            }
        }
        if (direction.equals(Direction.LEFT)) {
            if (currentX < SIZE - 1) {
                if (diagram[currentX+1][currentY ] != ' ' && diagram[currentX+1][currentY] != '\u0000') {
                    return Direction.DOWN;
                }
            }
            if (currentX > 0) {
                if (diagram[currentX-1][currentY] != ' ' && diagram[currentX-1][currentY] != '\u0000')
                    return Direction.UP;
            }
        }

        throw new Exception();
    }
}
