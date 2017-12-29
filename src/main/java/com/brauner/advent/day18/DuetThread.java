package com.brauner.advent.day18;

import java.util.Objects;

public class DuetThread extends Duet implements Runnable{

    int id;
    String input;
    int times;

    SenderReceiver sender;
    SenderReceiver receiver;

    DuetThread theOther;

    DuetThread(int id, String input, SenderReceiver sender, SenderReceiver receiver) {
        this.id = id;
        this.input = input;
        times = 0;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        System.out.println("program " + id + " started");
        recoverLastSound(input);
    }

    protected void receive(String register) {

        long val = receiver.receive();
            System.out.println("Consumer " + id + " "
                    + val);
            registers.put(register, val);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

    }

    protected void send(String register) {
        long value = 0;
            // producer thread waits while list
            // is full
        if (register.matches(".*\\d+.*"))
            value = Long.parseLong(register);
        else {
            if (registers.containsKey(register))
                value = registers.get(register);
            else {
                if (Objects.equals(register, "p")) {
                    value = id;
                }
            }
        }
        System.out.println("Producer " + id + " " + value + " times: " + (++times));

        // to insert the jobs in the list
        sender.send(value);


    }

    public SenderReceiver getSender() {
        return sender;
    }

    public void setSender(SenderReceiver sender) {
        this.sender = sender;
    }

    public SenderReceiver getReceiver() {
        return receiver;
    }

    public void setReceiver(SenderReceiver receiver) {
        this.receiver = receiver;
    }
}
