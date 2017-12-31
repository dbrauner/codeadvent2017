package com.brauner.advent.day21;

/**
 * Created by douglas on 30/12/2017.
 */
public class Rule {

    SquareGrid input;

    SquareGrid output;

    public Rule(String inputLine, String outputLine) {
        input = new SquareGrid();
        String[] lines = inputLine.split("/");
        input.pixels = new char[lines.length][lines.length];

        for (int i = 0; i < lines.length; i++) {
            input.pixels[i] = lines[i].toCharArray();
        }

        output = new SquareGrid();
        lines = outputLine.split("/");
        output.pixels = new char[lines.length][lines.length];

        for (int i = 0; i < lines.length; i++) {
            output.pixels[i] = lines[i].toCharArray();
        }
    }


    public boolean matchRule(SquareGrid pattern) {

        if (pattern.pixels.length != input.pixels.length)
            return false;

        char[][] pixels = pattern.pixels;
        for (int i = 0; i < 4; i++) {
            if (isPatternMatched(pixels))
                return true;
            char[][] flipped = flipPattern(pixels);
            if (isPatternMatched(flipped))
                return true;
            pixels = rotatePattern(pixels);
        }


        return false;
    }

    private char[][] flipPattern(char[][] pixels) {
        char[][] flipped = new char[pixels.length][pixels.length];
        for (int i = 0; i < pixels[0].length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                flipped[i][j] = pixels[i][pixels[0].length - j - 1];
            }
        }
        return flipped;

    }
    private char[][] rotatePattern(char[][] pixels) {
        char[][] flipped = new char[pixels.length][pixels.length];

        for(int i=0; i<pixels[0].length; i++){
            for(int j=pixels.length-1; j>=0; j--){
                flipped[i][pixels[0].length-1-j] = pixels[j][i];
            }
        }
        return flipped;
    }

    private boolean isPatternMatched(char[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[i][j] != input.pixels[i][j])
                    return false;
            }
        }
        return true;
    }
}
