package com.brauner.advent.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by douglas on 12/12/2017.
 */
public class DigitalPlumber {

    ArrayList<Pipe> pipes;

    int connectsToZero;

    public int find_0_GroupsId(String inputPath) throws IOException {
        pipes = new ArrayList<>();
        connectsToZero = 0;
        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            stream.forEach(this::processLine);
        }

        for (Pipe current: pipes) {
            if (reachesZeroID(current))
                connectsToZero++;

        }
        return connectsToZero;
    }

    private boolean reachesZeroID(Pipe current) {


        return false;
    }

    private void processLine(String s) {
        int id = Integer.parseInt(s.substring(0, s.indexOf(" ")));

        String connectionList = s.substring(s.indexOf(">") + 2);
        String[] connections = connectionList.split(",\\s");
        Pipe pipeInput = new Pipe();
        pipeInput.id = id;
        for (String connection : connections) {
            int connectionValue = Integer.parseInt(connection);
            Pipe nextPipe = new Pipe();
            nextPipe.id = connectionValue;
            nextPipe.nextPipes.add(nextPipe);
        }
    }


}
