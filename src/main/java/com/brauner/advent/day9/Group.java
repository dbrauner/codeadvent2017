package com.brauner.advent.day9;

import java.util.ArrayList;

/**
 * Created by douglas on 11/12/2017.
 */
public class Group {

    int score;

    boolean isOpened;

    int total;

    ArrayList<Group> child;

    Group parent;

    public Group() {
        score = 0;
        total = 0;
    }

    void groupOpen() {
        score++;

    }

    void groupClose() {
        total += score;
        score --;
    }
}
