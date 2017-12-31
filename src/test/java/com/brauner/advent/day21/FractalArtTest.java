package com.brauner.advent.day21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by douglas on 30/12/2017.
 */
public class FractalArtTest {

    @Test
    public void testGenerateArt() throws Exception {

        FractalArt fractalArt = new FractalArt();

        fractalArt.generateArt("src/test/resources/fractal.txt");

    }

}