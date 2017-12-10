package day7;

import java.util.ArrayList;

/**
 * Created by douglas on 09/12/2017.
 */
public class Program {

    String name;

    int weight;

    ArrayList<Program> subPrograms;

    Program topProgram;

    public Program(String name, int weight, ArrayList<Program> subPrograms, Program topProgram) {
        this.name = name;
        this.weight = weight;
        this.subPrograms = subPrograms;
        this.topProgram = topProgram;
    }

    public Program() {
    }

    public Program(String name) {
        this.name = name;
    }

    public Program getTopProgram() {
        return topProgram;
    }

    public void setTopProgram(Program topProgram) {
        this.topProgram = topProgram;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Program> getSubPrograms() {
        return subPrograms;
    }

    public void setSubPrograms(ArrayList<Program> subPrograms) {
        this.subPrograms = subPrograms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        boolean equal = name.equals(program.name);

        return equal;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
