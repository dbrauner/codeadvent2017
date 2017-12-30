package com.brauner.advent.day20;

import java.util.Objects;

/**
 * Created by douglas on 29/12/2017.
 */
public class Particle {
    int id;

    Coordinates position;
    Coordinates velocity;
    Coordinates acceleration;

    public Particle(Coordinates position, Coordinates velocity, Coordinates acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public long simulateTick() {
        updateVelocity();
        updatePosition();
        return determineManhatanDistance();
    }

    public long determineManhatanDistance() {
        return (Math.abs(this.position.x) + Math.abs(this.position.y) + Math.abs(this.position.z));
    }


    private void updatePosition() {
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
        this.position.z += this.velocity.z;

    }

    private void updateVelocity() {
        this.velocity.x += this.acceleration.x;
        this.velocity.y += this.acceleration.y;
        this.velocity.z += this.acceleration.z;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Particle particle = (Particle) o;
        return Objects.equals(position, particle.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
