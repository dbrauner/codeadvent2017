package com.brauner.advent.day9;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by douglas on 11/12/2017.
 */
public class StreamGroupFinder {

    Integer groups = 0;

    ArrayList<Group> groupArrayList;

    Group group;

    boolean skip;

    boolean garbage;

    int garbageCollected;

    int score;

    public int findValidGroups(InputStream input) throws IOException {
        groupArrayList = new ArrayList<>();
        score = 1;
        garbageCollected = 0;
        group = new Group();

        Reader reader = new InputStreamReader(input, "UTF-8");
        // buffer for efficiency
        Reader buffer = new BufferedReader(reader);
        handleCharacters(buffer);
        System.out.println("Total of " + garbageCollected + " garbage collected");
        return group.total;
    }

    private void handleCharacters(Reader reader) throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            parseValue(ch);
        }
    }

    private void parseValue(char ch) {
        if (skip) {
            skip = false;
            return;
        }

        if (ch == '!') {
            skip = true;
            return;
        }

        if (ch == '>' && garbage) {
            garbage = false;
            return;
        }

        if (garbage) {
            garbageCollected++;
            return;
        }

        if (ch == '<') {
            garbage = true;
            return;
        }

  //      if (String.valueOf(ch).matches("~[<&]+")) // match any 16 bit char other than < and &

        if (ch == '{') {
            group.groupOpen();
        }

        if (ch == '}') {
            group.groupClose();
        }

    }
}
