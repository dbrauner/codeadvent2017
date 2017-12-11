package com.brauner.advent.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by douglas on 09/12/2017.
 */
public class RecursiveCircus {

    ArrayList<Program> programs = new ArrayList<>();

    public String determineBottomProgram(String inputPath) throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            stream.forEach(this::parseProgramEntry);
        }
        Program base = programs.get(0);
        String topProgram = base.getName();
        while (base != null) {
            topProgram = base.getName();
            base = base.getTopProgram();
        }

        return topProgram;
    }

    public int determineFixWeight(String bottomProgramName) {

        int index = programs.indexOf(new Program(bottomProgramName));
        Program bottomProgram = programs.get(index);

        System.out.println("total :" + this.calculateTotal(bottomProgram));

        return findImbalance(bottomProgram, 0);
    }

    private int findImbalance(Program program, int imbalance) {

        if (noChildren(program) || isChildrenBalanced(program)) {
            if (imbalance == 0) {
                System.out.println("Balanced!");
                return 0;
            }
            int originalWeight =  program.getWeight() - sumOfChildren(program);
            int correctValue = originalWeight + imbalance;
            System.out.println("correct value :" + correctValue + " for: " + program.getName());
            return correctValue;
        }

        Map<Integer, Integer> valueAndTimes = new HashMap<>();

        for (Program children : program.getSubPrograms()) {
            Integer value = children.getWeight();
            if (valueAndTimes.get(value) != null){
                Integer times = valueAndTimes.get(value);
                valueAndTimes.replace(value, ++times);
            } else {
                valueAndTimes.put(value, 1);
            }
        }

        Program imbalancedProgram = null;
        int othersValue = 0;
        for (Program children : program.getSubPrograms()) {
            Integer value = children.getWeight();
            if (valueAndTimes.get(value) == 1){
                imbalancedProgram = children;
            } else
                othersValue = children.getWeight();
        }

        int difference = othersValue - imbalancedProgram.getWeight() ;
        System.out.println("Bad node: " + imbalancedProgram.getName() + " should add: " + difference);

        return findImbalance(imbalancedProgram, difference);
    }

    private int calculateTotal(Program program) {
        if (noChildren(program) || isChildrenBalanced(program)) {
            program.setWeight(sumOfChildren(program) + program.getWeight());
            System.out.println("name: " + program.getName() + " weight: " + program.getWeight());
            return program.getWeight();
        }
        for (Program child : program.getSubPrograms()) {
            program.setWeight(program.getWeight() + calculateTotal(child));
        }
        return program.getWeight();

    }



    private boolean noChildren(Program program) {
        return program.getSubPrograms().isEmpty();
    }

    private int sumOfChildren(Program program) {
        int total = 0;

        for (Program children : program.getSubPrograms()) {
            total += children.getWeight();
        }
        return total;
    }

    private boolean isChildrenBalanced(Program program) {

        int lastWeight = 0;

        for (Program children : program.getSubPrograms()) {
            if (lastWeight != 0 && children.getWeight() != lastWeight )
                return false;
            lastWeight = children.getWeight();
        }
        return true;
    }

    private void parseProgramEntry(String line) {
        String programName = line.substring(0, line.indexOf(" "));
        int programWheight = Integer.parseInt(line.substring(line.indexOf("(")+1, line.indexOf(")")));
        String[] childProgramList = {};
        if (hasChilds(line)) {
            String childPrograms = line.substring(line.indexOf(">") + 2);
            childProgramList = childPrograms.split(",\\s");
        }

        Program program = new Program(programName, programWheight, new ArrayList<>(), null);
        if (programs.contains(program)) {
            int indexOfProgram = programs.indexOf(program);
            program = programs.get(indexOfProgram);
            program.setWeight(programWheight);

        }

        for (String childProgram : childProgramList) {
            Program child = new Program();
            child.setSubPrograms(new ArrayList<>());
            child.setName(childProgram);
            if (programs.contains(child)) {
                int indexOfProgram = programs.indexOf(child);
                child = programs.get(indexOfProgram);
            }
            child.setTopProgram(program);
            program.getSubPrograms().add(child);

            if (!programs.contains(child))
                programs.add(child);
        }
        if (programs.contains(program)) {
            int indexOfProgram = programs.indexOf(program);
            programs.set(indexOfProgram, program);
        } else
            programs.add(program);

    }

    private boolean hasChilds(String string) {
        return string.contains(">");
    }

}
