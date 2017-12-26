package com.brauner.advent.day18;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuetTest {
    @Test
    public void recoverLastSoundTest() throws Exception {

        String inputTest = "set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2";

        Duet duet = new Duet();

        System.out.println("last sound: " + duet.recoverLastSound(inputTest));
    }

    @Test
    public void recoverLastSound() throws Exception {

        String inputTest = "set i 31\n" +
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

        Duet duet = new Duet();

        System.out.println("last sound: " + duet.recoverLastSound(inputTest));
    }

    @Test
    public void DuetThreadTest() throws InterruptedException {
        String input = "snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d";

        SenderReceiver s0 = new SenderReceiver();
        SenderReceiver s1 = new SenderReceiver();

        DuetThread p0 = new DuetThread(0, input, s0, s1);
//        DuetThread p1 = new DuetThread(1, input, s1, s0);

        System.out.println("start");
        new Thread(p0).start();
  //      new Thread(p1).start();

        while(true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }

    @Test
    public void DuetThread() throws InterruptedException {
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

        SenderReceiver s0 = new SenderReceiver();
        SenderReceiver s1 = new SenderReceiver();

        DuetThread p0 = new DuetThread(0, input, s0, s1);
        DuetThread p1 = new DuetThread(1, input, s1, s0);

        System.out.println("start");
        new Thread(p0).start();
        //Thread.sleep(10000);
        new Thread(p1).start();

        while(true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }


}