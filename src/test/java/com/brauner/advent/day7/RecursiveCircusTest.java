package com.brauner.advent.day7;

import org.junit.Test;

/**
 * Created by douglas on 09/12/2017.
 */
public class RecursiveCircusTest {
    @Test
    public void determineBottomProgram() throws Exception {

        RecursiveCircus circus = new RecursiveCircus();
        String bottomProgram = circus.determineBottomProgram("src/test/resources/recursiveCircusTest.txt");
        System.out.println("Bottom program: " + bottomProgram );

        System.out.println("Weight to fix: " + circus.determineFixWeight(bottomProgram));




        circus = new RecursiveCircus();
        bottomProgram = circus.determineBottomProgram("src/test/resources/recursiveCircus.txt");
                System.out.println("Bottom program: " + bottomProgram);

        System.out.println("Weight to fix: " + circus.determineFixWeight(bottomProgram));

    }

}