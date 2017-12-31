package com.brauner.advent.day21;

/**
 * Created by douglas on 30/12/2017.
 */
public class SquareGrid {

    char[][] pixels;

    int lastPartLine;
    int lastPartColumn;

    public void initializePattern() {
        pixels = new char[][] {{'.', '#', '.'}, {'.', '.', '#'}, {'#', '#', '#'}};
    }


    public void print() {

        int pixelsOn = 0;

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels.length; j++) {
                System.out.print(pixels[i][j]);
                if (pixels[i][j] == '#')
                    pixelsOn++;
            }
            System.out.println();

        }
        System.out.println("There are " + pixelsOn + " pixels on");
    }


    public char[][] getNextPart(int size) {

        char[][] result = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = pixels[i + lastPartLine][j + lastPartColumn];
            }
        }

        if (lastPartColumn + size == pixels.length) {
            lastPartColumn = 0;
            lastPartLine += size;
        } else
            lastPartColumn += size;

        return result;
    }

    public boolean hasNext(int size) {
        return lastPartLine + size <= pixels.length;
    }
}
