package com.brauner.advent.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by douglas on 12/12/2017.
 */
public class DigitalPlumber {

    Map<Integer, Pipe> pipes;

    int connectsToZero;

    List<Pipe> pipesVisited;

    List<Pipe> pipeInGroup;

    int currentId;

    public int find_0_GroupsId(String inputPath) throws IOException {
        pipes = new HashMap<>();
        connectsToZero = 0;
        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            stream.forEach(this::processLine);
        }
        currentId = 0;

        for (Pipe current: pipes.values()) {
            pipesVisited = new ArrayList<>();
            if (reachesCurrentID(current))
                connectsToZero++;
        }
        return connectsToZero;
    }

    public int findDistinctGroups(String inputPath) throws IOException {
        pipes = new HashMap<>();
        int distinctGroups = 0;
        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            stream.forEach(this::processLine);
        }

        currentId = 0;
        pipeInGroup = new ArrayList<>();
        int lastSize = 0;
        for (int i = 0; i < pipes.size(); i++) {
            currentId = i;
            for (Pipe current: pipes.values()) {
                pipesVisited = new ArrayList<>();
                if (pipeInGroup.contains(current))
                    continue;
                if (reachesCurrentID(current)) {
                    pipeInGroup.add(current);
                }
            }
            if (pipeInGroup.size() > lastSize) {
                lastSize = pipeInGroup.size();
                distinctGroups++;
            }
        }
        return distinctGroups;
    }


    private boolean reachesCurrentID(Pipe current) {

        if (current.id == currentId) {
            return true;
        }
        if (alreadyVisited(current)) {
            return false;
        }

        for (Pipe nextPipe : current.nextPipes) {
            if (reachesCurrentID(nextPipe))
                return true;
        }
        return false;
    }

    private boolean alreadyVisited(Pipe visit) {
        if (pipesVisited.contains(visit)) {
            return true;
        }
        pipesVisited.add(visit);
        return false;
    }

    private void processLine(String s) {
        int id = Integer.parseInt(s.substring(0, s.indexOf(" ")));

        String connectionList = s.substring(s.indexOf(">") + 2);
        String[] connections = connectionList.split(",\\s");
        Pipe pipeInput = new Pipe(id);
        if (pipes.containsValue(pipeInput)) {
            pipeInput = pipes.get(id);
        }
        pipes.put(id, pipeInput);

        for (String connection : connections) {
            int connectionValue = Integer.parseInt(connection);
            Pipe nextPipe = new Pipe(connectionValue);
            if (pipes.containsValue(nextPipe)) {
                nextPipe = pipes.get(connectionValue);
            }
            pipes.put(nextPipe.id, nextPipe);
            pipeInput.nextPipes.add(nextPipe);
        }
    }


}
