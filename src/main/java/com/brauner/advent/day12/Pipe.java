package com.brauner.advent.day12;

import java.util.ArrayList;

/**
 * Created by douglas on 12/12/2017.
 */
public class Pipe {

    Integer id;

    ArrayList<Pipe> nextPipes;

    public Pipe() {

    }

    public Pipe(Integer id) {
        this.id = id;
        nextPipes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pipe pipe = (Pipe) o;

        return id != null ? id.equals(pipe.id) : pipe.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
