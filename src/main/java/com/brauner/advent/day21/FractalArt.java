package com.brauner.advent.day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by douglas on 30/12/2017.
 */
public class FractalArt {

    SquareGrid grid;

    int LOOPS = 18;

    ArrayList<Rule> rules;

    public void generateArt(String rulesPath) throws Exception {

        grid = new SquareGrid();
        rules = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(rulesPath))) {

            stream.forEach(this::processInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        grid.initializePattern();

        for (int i = 0; i < LOOPS; i++) {
            enhancePattern();
            grid.print();
        }

        grid.print();

    }

    private void enhancePattern() throws Exception {
        SquareGrid[][] subgrids = null;
        if (grid.pixels.length % 2 == 0) {
            subgrids = splitGrid(2);
        } else if (grid.pixels.length % 3 == 0) {
            subgrids = splitGrid(3);
        }

        for (int i = 0; i < subgrids.length; i++) {
            for (int j = 0; j < subgrids.length; j++) {

                for (Rule rule : rules) {
                    if (rule.matchRule(subgrids[i][j])) {
                        subgrids[i][j] = rule.output;
                        break;
                    }
                }
            }
        }

        joinSubGrids(subgrids);
    }

    private void joinSubGrids(SquareGrid[][] subgrids) {
        int newSize = subgrids.length * subgrids[0][0].pixels.length;
        grid.pixels = new char[newSize][newSize];

        int chunkSizeLine = 0;
        int chunkSizeColumn = 0;
        int chunk = subgrids[0][0].pixels.length;

        for (int i = 0; i < subgrids.length; i++) {
            for (int j = 0; j < subgrids.length; j++) {
                joinOneGrid(subgrids[i][j], chunkSizeLine, chunkSizeColumn);
                chunkSizeColumn += chunk;
            }
            chunkSizeLine += chunk;
            chunkSizeColumn = 0;
        }
    }

    private void joinOneGrid(SquareGrid squareGrid, int line, int column) {

        for (int i = 0; i < squareGrid.pixels.length; i++) {
            for (int j = 0; j < squareGrid.pixels.length; j++) {
                grid.pixels[i + line][ j + column] = squareGrid.pixels[i][j];
            }
        }
    }

    private SquareGrid[][] splitGrid(int i) throws Exception {
        grid.lastPartColumn = grid.lastPartLine = 0;
        int size = grid.pixels.length / i;
        SquareGrid[][] subgrids = new SquareGrid[size][size];

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                if (!grid.hasNext(i)) {
                    throw new Exception(" fudeu");
                }
                subgrids[j][k] = new SquareGrid();
                subgrids[j][k].pixels = grid.getNextPart(i);
            }
        }
        return subgrids;
    }

    private void processInput(String s) {

        rules.add(new Rule(s.substring(0, s.indexOf(" ")), s.substring(s.indexOf('>') + 2)));

    }

}
