package com.brauner.advent.day11;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by douglas on 12/12/2017.
 */
public class HexGridMazeTest {
    @Test
    public void determineStepsShortestPath() throws Exception {

        HexGridMaze hexGridMaze = new HexGridMaze();

        String input = "ne,ne,ne";
        System.out.println("Steps: " + hexGridMaze.determineStepsShortestPath(input));

        input = "ne,ne,sw,sw";
        System.out.println("Steps: " + hexGridMaze.determineStepsShortestPath(input));

        input = "ne,ne,s,s";
        System.out.println("Steps: " + hexGridMaze.determineStepsShortestPath(input));

        input = "se,sw,se,sw,sw";
        System.out.println("Steps: " + hexGridMaze.determineStepsShortestPath(input));

        try (Stream<String> streaming = Files.lines(Paths.get("src/test/resources/hexmaze.txt"))) {

            streaming.forEach(this::parseFile);
        }
    }

    private void parseFile(String s) {
        HexGridMaze hexGridMaze = new HexGridMaze();
        System.out.println("Steps: " + hexGridMaze.determineStepsShortestPath(s));

    }

}