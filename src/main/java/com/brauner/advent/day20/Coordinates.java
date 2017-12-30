package com.brauner.advent.day20;

import java.util.Objects;

/**
 * Created by douglas on 29/12/2017.
 */
public class Coordinates {

    long x;
    long y;
    long z;

    public Coordinates(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y &&
                z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
