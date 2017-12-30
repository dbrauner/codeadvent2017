package com.brauner.advent.day20;

import org.junit.Test;

/**
 * Created by douglas on 29/12/2017.
 */
public class ParticleSwarmTest {

    @Test
    public void testInput() {
        ParticleSwarm particleSwarm = new ParticleSwarm();
        particleSwarm.simulateParticles("src/test/resources/particleTest.txt");

    }

    @Test
    public void testReal() {
        ParticleSwarm particleSwarm = new ParticleSwarm();
        particleSwarm.simulateParticles("src/test/resources/particle.txt");

    }

}