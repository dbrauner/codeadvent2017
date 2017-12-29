package com.brauner.advent.day16;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by douglas on 16/12/2017.
 */
public class PermutationPromenade {

    int programSize = 16;

    ArrayList<String> programs;

    public String makeProgramsDance(String input) {

        initializePrograms();

        String[] commands = input.split(",");

        processCommands(commands);

        StringBuilder result = new StringBuilder();
        for (String program : programs) {
            result.append(program);
        }

        return result.toString();
    }

    private void processCommands(String[] commands) {
        for (String command : commands) {

            if (command.startsWith("s"))
                spin(command);
            if (command.startsWith("x"))
                exchange(command);
            if (command.startsWith("p"))
                partner(command);
        }
    }

    private void partner(String command) {
        String [] swaps = command.substring(1).split("/");
        int a  = programs.indexOf(swaps[0]);
        int b  = programs.indexOf(swaps[1]);

        Collections.swap(programs, a, b);
    }

    private void exchange(String command) {
        String [] swaps = command.substring(1).split("/");
        int a = Integer.parseInt(swaps[0]);
        int b = Integer.parseInt(swaps[1]);

        Collections.swap(programs, a, b);
    }

    private void spin(String command) {
        int times = Integer.parseInt(command.substring(1));
        Collections.rotate(programs, times);
    }

    private void initializePrograms() {
        programs = new ArrayList<>();
        for (int i = 0; i < programSize; i++) {
            programs.add(Character.toString ((char) (i + 97)));
        }
    }

    public String makeProgramsDance1Billion(String input) {

        initializePrograms();

        String[] commands = input.split(",");

        StringBuilder start = new StringBuilder();
        for (String program : programs) {
            start.append(program);
        }
        for (long i = 0; i < 16; i++) {
            processCommands(commands);
            StringBuilder current = new StringBuilder();
            for (String program : programs) {
                current.append(program);
            }
            if (current.toString().equals(start.toString()))
                System.out.println("found pattern at " + i);
        }
        StringBuilder result = new StringBuilder();
        for (String program : programs) {
            result.append(program);
        }

        return result.toString();
    }
}
