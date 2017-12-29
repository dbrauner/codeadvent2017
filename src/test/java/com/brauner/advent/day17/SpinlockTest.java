package com.brauner.advent.day17;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpinlockTest {
    @Test
    public void shortCircuitTheHurricaneTest() throws Exception {
        Spinlock spinlock = new Spinlock();

        System.out.println("short-circuit at :" + spinlock.shortCircuitTheHurricane(3));
    }

    @Test
    public void shortCircuitTheHurricane() throws Exception {
        Spinlock spinlock = new Spinlock();

        System.out.println("short-circuit at :" + spinlock.shortCircuitTheHurricane(343));
    }

    @Test
    public void shortCircuitTheHugeHurricane() throws Exception {
        Spinlock spinlock = new Spinlock();

        System.out.println("short-circuit at :" + spinlock.shortCircuitTheHugeHurricane(343));
    }
}