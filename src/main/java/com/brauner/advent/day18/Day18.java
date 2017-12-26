package com.brauner.advent.day18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day18 {

    private enum Instruction {
        snd (Instruction::snd),
        set (Instruction::set),
        add (Instruction::add),
        mul (Instruction::mul),
        mod (Instruction::mod),
        rcv (Instruction::rcv),
        jgz (Instruction::jgz);

        private final BiFunction<Map<String, Long>, Command, Long> function;

        Instruction (BiFunction<Map<String, Long>, Command, Long> function) {
            this.function= function;
        }

        public Long apply (Map<String, Long> registers, Command command) {
            return this.function.apply(registers, command);
        }

        private static Long snd (Map<String, Long> registers, Command command) {
            return asInt(registers, command.registerX, command);
        }

        private static Long set (Map<String, Long> registers, Command command) {
            Long value= asInt(registers, command.valueX, command);
            registers.put(command.registerX, value);
            return null;
        }

        private static Long add (Map<String, Long> registers, Command command) {
            Long existing= asInt(registers, command.registerX, command);
            Long other= asInt(registers, command.valueX, command);
            registers.put(command.registerX, existing + other);
            return null;
        }

        private static Long mul (Map<String, Long> registers, Command command) {
            Long existing= asInt(registers, command.registerX, command);
            Long other= asInt(registers, command.valueX, command);
            registers.put(command.registerX, existing * other);
            return null;
        }

        private static Long mod (Map<String, Long> registers, Command command) {
            Long existing= asInt(registers, command.registerX, command);
            Long other= asInt(registers, command.valueX, command);
            registers.put(command.registerX, existing % other);
            return null;
        }

        private static Long rcv (Map<String, Long> registers, Command command) {
            if (asInt(registers, command.valueX, command) > 0) {
                return Long.valueOf(Integer.MAX_VALUE);
            }
            return null;
        }

        private static Long jgz (Map<String, Long> registers, Command command) {
            if (asInt(registers, command.registerX, command) > 0) {
                return asInt(registers, command.valueX, command);
            }
            return null;
        }

        public static Long asInt (Map<String, Long> registers, String key, Command command) {
            try {
                return Long.parseLong(key);
            } catch (NumberFormatException nfe) {
                return registers.getOrDefault(key, command.defaultValue);
            }
        }
    }

    private static class Command {
        final String registerX;
        final String valueX;
        final Instruction instruction;
        private Long defaultValue;

        Command (Instruction instruction, String regX, String valX) {
            this.instruction= instruction;
            this.registerX= regX;
            this.valueX= valX;
        }

        @Override
        public String toString() {
            return this.instruction + " regX=" + registerX + " valX=" + valueX;
        }

        public Long apply (Map<String, Long> registers, int defaultValue) {
            this.defaultValue= (long)defaultValue;
            return this.instruction.apply(registers, this);
        }
    }

    @Test
    public void runTask1() {
        assertThat(solveTask1(getInputLines()), is(9423));
    }

    @Test
    public void runTask2() {
        assertThat(solveTask2(getInputLines()), is(7620));
    }

    public List<String> getInputLines() {
        String input = "set i 31\n" +
                "set a 1\n" +
                "mul p 17\n" +
                "jgz p p\n" +
                "mul a 2\n" +
                "add i -1\n" +
                "jgz i -2\n" +
                "add a -1\n" +
                "set i 127\n" +
                "set p 464\n" +
                "mul p 8505\n" +
                "mod p a\n" +
                "mul p 129749\n" +
                "add p 12345\n" +
                "mod p a\n" +
                "set b p\n" +
                "mod b 10000\n" +
                "snd b\n" +
                "add i -1\n" +
                "jgz i -9\n" +
                "jgz a 3\n" +
                "rcv b\n" +
                "jgz b -1\n" +
                "set f 0\n" +
                "set i 126\n" +
                "rcv a\n" +
                "rcv b\n" +
                "set p a\n" +
                "mul p -1\n" +
                "add p b\n" +
                "jgz p 4\n" +
                "snd a\n" +
                "set a b\n" +
                "jgz 1 3\n" +
                "snd b\n" +
                "set f 1\n" +
                "add i -1\n" +
                "jgz i -11\n" +
                "snd a\n" +
                "jgz f -16\n" +
                "jgz a -19";
        String[] list = input.split("\\n");


        return Arrays.asList(list);
    }

    @Test
    public void runExample1() {
        assertThat(solveTask1(Arrays.asList("set a 1",
                "add a 2",
                "mul a a",
                "mod a 5",
                "snd a",
                "set a 0",
                "rcv a",
                "jgz a -1",
                "set a 1",
                "jgz a -2")), is(4));
    }

    @Test
    public void runExample2() {
        assertThat(solveTask2(Arrays.asList("snd 1",
                "snd 2",
                "snd p",
                "rcv a",
                "rcv b",
                "rcv c",
                "rcv d")), is(3));
    }

    private int solveTask1 (List<String> input) {
        List<Command> commands = input.stream()
                .map(this::parse)
                .collect(Collectors.toList());
        Long lastSound= null;
        Long recovered = null;

        Map<String, Long> registers= new HashMap<>();
        for (int i = 0; i < commands.size(); i++) {
            Command c= commands.get(i);
            Long result= c.apply(registers, 0);

            if (Instruction.snd == c.instruction) {
                lastSound= result;
            } else if (Instruction.rcv == c.instruction) {
                if (result != null && Integer.MAX_VALUE == result) {
                    recovered= lastSound;
                    break;
                }
            } else if (Instruction.jgz == c.instruction && result != null) {
                int nextI= i - 1 + result.intValue();
                if (nextI < 0 || nextI >= commands.size()) {
                    break;
                }
                i= nextI;
            }
        }
        return recovered.intValue();
    }

    static class Program {
        final int id;
        private final List<Command> commands;

        private Program other;

        private Map<String, Long> registers= new HashMap<>();
        private final List<Long> queue= new ArrayList<>();
        private int instructionIndex;
        private Command receiveWait;

        private int sendCounter= 0;
        private boolean terminated;

        private Program (int id, List<Command> commands) {
            this.id= id;
            this.commands= commands;
        }

        public void tick() {
            if (terminated) {
                // ticked, but already terminated
                return;
            }

            Command c= commands.get(instructionIndex);
            Long result= c.apply(registers, id);

            if (receiveWait != null) {
                if (queue.size() == 0) {
                    // still waiting
                    return;
                } else {
                    receive(receiveWait);
                    receiveWait= null;
                    return;
                }
            }

            instructionIndex++;
            if (Instruction.snd == c.instruction) {
                notifyOther(result);
            } else if (Instruction.rcv == c.instruction) {
                if (queue.size() == 0) {
                    receiveWait= c;
                } else {
                    receive(c);
                }
            } else if (Instruction.jgz == c.instruction && result != null) {
                int nextI= instructionIndex - 1 + result.intValue();
                if (nextI < 0 || nextI >= commands.size()) {
                    terminated= true;
                    return;
                }
                instructionIndex= nextI;
            }
        }

        private Long notifyOther (Long result) {
            sendCounter++;
            other.queue.add(result);
            return null;
        }

        private void receive (Command c) {
            Long first= queue.get(0);
            queue.remove(0);
            registers.put(c.valueX, first);
        }

    }
    private int solveTask2 (List<String> input) {
        List<Command> commands = input.stream()
                .map(this::parse)
                .collect(Collectors.toList());

        Program p0= new Program(0, commands);
        Program p1= new Program(1, commands);
        p0.other= p1;
        p1.other= p0;

        while (true) {
            if (p0.terminated && p1.terminated ||
                    p0.receiveWait != null && p1.receiveWait != null) {
                break;
            }
            p0.tick();
            p1.tick();
        }
        return p1.sendCounter;
    }

    private Command parse(String line) {
        String[] tokens= line.split(" ");
        Instruction instruction= Instruction.valueOf(tokens[0]);

        switch(instruction) {
            case snd:
                return new Command(Instruction.snd, tokens[1], null);
            case rcv:
                return new Command(Instruction.rcv, null, tokens[1]);
            default:
                return new Command(instruction, tokens[1], tokens[2]);
        }
    }

}