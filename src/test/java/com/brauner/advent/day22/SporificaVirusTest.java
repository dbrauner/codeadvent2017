package com.brauner.advent.day22;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by douglas on 31/12/2017.
 */
public class SporificaVirusTest {


    @Test
    public void testSporificaVirus() {

        SporificaVirus virus = new SporificaVirus();
        String input = "..#\n" +
                       "#..\n" +
                       "...";
        virus.runMap(input);

        input = "###.#######...#####.#..##\n" +
                ".####...###.##...#..#....\n" +
                ".#.#...####.###..##..##.#\n" +
                "########.#.#...##.#.##.#.\n" +
                "..#.#...##..#.#.##..####.\n" +
                "..#.#.....#....#####..#..\n" +
                "#.#..##...#....#.##...###\n" +
                ".#.##########...#......#.\n" +
                ".#...#..##...#...###.#...\n" +
                "......#.###.#..#...#.####\n" +
                ".#.###.##...###.###.###.#\n" +
                ".##..##...#.#.#####.#...#\n" +
                "#...#..###....#.##.......\n" +
                "####.....######.#.##..#..\n" +
                "..#...#..##.####.#####.##\n" +
                "#...#.#.#.#.#...##..##.#.\n" +
                "#####.#...#.#.#.#.##.####\n" +
                "....###...#.##.#.##.####.\n" +
                ".#....###.#####...#.....#\n" +
                "#.....#....#####.#..#....\n" +
                ".#####.#....#..##.#.#.###\n" +
                "####.#..#..##..#.#..#.###\n" +
                ".##.##.#.#.#.#.#..####.#.\n" +
                "#####..##.#.#..#..#...#..\n" +
                "#.#..#.###...##....###.##";

        virus = new SporificaVirus();
        virus.runMap(input);
    }

    @Test
    public void evolvedVirusTest() {
        SporificaVirus evolved = new EvolvedSporificaVirus();

        String input = "###.#######...#####.#..##\n" +
                ".####...###.##...#..#....\n" +
                ".#.#...####.###..##..##.#\n" +
                "########.#.#...##.#.##.#.\n" +
                "..#.#...##..#.#.##..####.\n" +
                "..#.#.....#....#####..#..\n" +
                "#.#..##...#....#.##...###\n" +
                ".#.##########...#......#.\n" +
                ".#...#..##...#...###.#...\n" +
                "......#.###.#..#...#.####\n" +
                ".#.###.##...###.###.###.#\n" +
                ".##..##...#.#.#####.#...#\n" +
                "#...#..###....#.##.......\n" +
                "####.....######.#.##..#..\n" +
                "..#...#..##.####.#####.##\n" +
                "#...#.#.#.#.#...##..##.#.\n" +
                "#####.#...#.#.#.#.##.####\n" +
                "....###...#.##.#.##.####.\n" +
                ".#....###.#####...#.....#\n" +
                "#.....#....#####.#..#....\n" +
                ".#####.#....#..##.#.#.###\n" +
                "####.#..#..##..#.#..#.###\n" +
                ".##.##.#.#.#.#.#..####.#.\n" +
                "#####..##.#.#..#..#...#..\n" +
                "#.#..#.###...##....###.##";

        evolved.LOOPS = 10000000;
        evolved.runMap(input);


    }

}