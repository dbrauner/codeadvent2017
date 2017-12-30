package com.brauner.advent.day20;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by douglas on 29/12/2017.
 */
public class CollisionParticleSwarmTest {

    @Test
    public void testCollision() {

        String path = "src/test/resources/collisionParticleTest.txt";
        ParticleSwarm particleSwarm = new CollisionParticleSwarm();
        particleSwarm.simulateParticles(path);
    }

    @Test
    public void collisionDetect() {

        String path = "src/test/resources/particle.txt";
        ParticleSwarm particleSwarm = new CollisionParticleSwarm();
        particleSwarm.simulateParticles(path);
    }
}