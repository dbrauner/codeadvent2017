package day5;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by douglas on 09/12/2017.
 */
public class TrampolineMazeTest {

    @Test
    public void findMazeExitTest() {
        TrampolineMaze maze = new TrampolineMaze();

        String testInput = "0\n3\n0\n1\n-3";
        int[] list = Arrays.stream(testInput.split("\\n")).mapToInt(Integer::parseInt).toArray();

        System.out.println("steps: " + maze.findMazeExitPositiveOffset(list));
    }

    @Test
    public void findMazeExitFromFileTest() throws IOException {

        TrampolineMaze maze = new TrampolineMaze();

        try (Stream<String> stream = Files.lines(Paths.get("src/test/resources/mazelist.txt"))) {

            int[] list = stream.mapToInt(Integer::parseInt).toArray();

            System.out.println("steps: " + maze.findMazeExitPositiveOffset(list));
        }
    }

    @Test
    public void findMazeExitNegativeOffsetTest() {
        TrampolineMaze maze = new TrampolineMaze();

        String testInput = "0\n3\n0\n1\n-3";
        int[] list = Arrays.stream(testInput.split("\\n")).mapToInt(Integer::parseInt).toArray();

        System.out.println("steps: " + maze.findMazeExitNegativeOffset(list));
    }

    @Test
    public void findMazeExitNegativeOffsetFromFileTest() throws IOException {

        TrampolineMaze maze = new TrampolineMaze();

        try (Stream<String> stream = Files.lines(Paths.get("src/test/resources/mazelist.txt"))) {

            int[] list = stream.mapToInt(Integer::parseInt).toArray();

            System.out.println("steps: " + maze.findMazeExitNegativeOffset(list));
        }
    }

}