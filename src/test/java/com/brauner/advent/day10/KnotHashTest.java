package com.brauner.advent.day10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by douglas on 11/12/2017.
 */
public class KnotHashTest {
    @Test
    public void calculateHash() throws Exception {

        KnotHash knotHash = new KnotHash();
        String input = "3,4,1,5";

        System.out.println("Value: " + knotHash.calculateHash(input));
    }

    @Test
    public void calculateHashReal() throws Exception {

        KnotHash knotHash = new KnotHash();
        String input = "157,222,1,2,177,254,0,228,159,140,249,187,255,51,76,30";

        System.out.println("Value: " + knotHash.calculateHash(input));
    }


    @Test
    public void calculateHashRealXorValue() throws Exception {

        KnotHash knotHash = new KnotHash();
        String input = "157,222,1,2,177,254,0,228,159,140,249,187,255,51,76,30";

        System.out.println("Value: " + knotHash.calculateHashWithASCII(input));
    }
    @Test
    public void determineXorValue() {
        KnotHash knotHash = new KnotHash();
        int[] list = {65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22};
        System.out.println("Xor " + knotHash.determineXorValue(list));
    }


}