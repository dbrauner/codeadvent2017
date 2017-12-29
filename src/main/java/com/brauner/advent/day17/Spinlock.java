package com.brauner.advent.day17;

import org.magicwerk.brownies.collections.GapList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spinlock {

    GapList<Integer> buffer;
    private static int TIMES = 2017;
    private static int HUGE_TIMES = 50000000;
    private int lastValue;
    private int bufferIndex;

    public int shortCircuitTheHurricane(int inputSteps) {

        buffer = new GapList<>();
        buffer.add(0);
        lastValue = 0;
        bufferIndex = 0;

        for (int i = 0; i < TIMES; i++) {
            doCollectionsSpin(inputSteps);
        }

        System.out.println("at index 1531: " + buffer.get(1531));

        System.out.println("index: " + (bufferIndex + 1));
        return buffer.get(0);
    }

    public int shortCircuitTheHugeHurricane(int inputSteps) {

        buffer = new GapList<>();
        buffer.add(0);
        lastValue = 0;
        bufferIndex = 0;

        for (int i = 0; i < HUGE_TIMES; i++) {
            doSpin(inputSteps);
        }
        return buffer.get(buffer.indexOf(0) + 1);
    }

    private void doSpin(int steps) {

        int mod = Math.floorMod(steps, buffer.size());

        if (bufferIndex + mod < buffer.size())
            bufferIndex+= mod;
        else {
            bufferIndex = (bufferIndex + mod) - buffer.size();
        }

        lastValue++;
        bufferIndex++;
        buffer.add(bufferIndex, lastValue);

    }

    private void doCollectionsSpin(int steps) {
        Collections.rotate(buffer, -steps);
        lastValue++;
        buffer.add(lastValue);

    }
}
