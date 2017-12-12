package com.brauner.advent.day12;

import com.brauner.advent.day4.PassphraseValidator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by douglas on 12/12/2017.
 */
public class DigitalPlumberTest {
    @Test
    public void find_0_GroupsIdTest() throws Exception {

        DigitalPlumber plumber = new DigitalPlumber();
        System.out.println("Reaches Zero: " + plumber.find_0_GroupsId("src/test/resources/plumberTest.txt"));

        plumber = new DigitalPlumber();
        System.out.println("Reaches Zero: " + plumber.find_0_GroupsId("src/test/resources/plumber.txt"));

    }
}