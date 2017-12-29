package com.brauner.advent.day19;

import org.junit.Test;

public class TubeScreamerTest {
    @Test
    public void tubeScreamerTest() throws Exception {

        TubeScreamer tubeScreamer = new TubeScreamer();
        String path = "src/test/resources/tube.txt";
        System.out.println(tubeScreamer.walkTubes(path));
    }

    @Test
    public void tubeScreamer() throws Exception {

        TubeScreamer tubeScreamer = new TubeScreamer();
        String path = "src/test/resources/tubeInput.txt";
        System.out.println(tubeScreamer.walkTubes(path));
    }
}