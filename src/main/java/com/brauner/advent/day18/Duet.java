package com.brauner.advent.day18;

import java.util.HashMap;
import java.util.Map;

public class Duet {

    String lastSound = "";
    Map<String, Long> registers;

    public long recoverLastSound(String input) {

        registers = new HashMap<>();

        String[] instructions = input.split("\\n");

        for (int i = 0; i < instructions.length; i++) {
            String register = instructions[i].substring(4, 5);
            long value = 0;
            if (instructions[i].length() > 6) {
                if (instructions[i].substring(6).matches(".*\\d+.*"))
                    value = Long.parseLong(instructions[i].substring(6));
                else
                    value = registers.get(instructions[i].substring(6));
            }
            if (instructions[i].contains("set")) {
                registers.put(register, value);

            }
            if (instructions[i].contains("add")) {
                if (registers.containsKey(register)) {
                    long oldValue = registers.get(register);
                    registers.put(register, oldValue + value);
                } else
                    registers.put(register, value);
            }
            if (instructions[i].contains("mul")) {
                if (registers.containsKey(register)) {
                    long oldValue = registers.get(register);
                    registers.put(register, oldValue * value);
                } else
                    registers.put(register, 0L);
            }
            if (instructions[i].contains("mod")) {
                if (registers.containsKey(register)) {
                    long oldValue = registers.get(register);
                    registers.put(register, oldValue % value);
                } else
                    registers.put(register, 0L);
            }
            if (instructions[i].contains("snd")) {
                send(instructions[i].substring(4, 5));
                lastSound = register;
            }
            if (instructions[i].contains("rcv")) {
                receive(register);
                if (registers.containsKey(register)) {
                }
            }
            if (instructions[i].contains("jgz")) {
                if (registers.containsKey(register)) {
                    if (registers.get(register) > 0)
                        i += value - 1;
                }
            }
        }
        return registers.get(lastSound);
    }

    protected void receive(String register) {

    }

    protected void  send(String register) {
    }
}
