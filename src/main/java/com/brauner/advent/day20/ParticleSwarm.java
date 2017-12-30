package com.brauner.advent.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by douglas on 29/12/2017.
 */
public class ParticleSwarm {

    ArrayList<Particle> particles;

    long closest = Long.MAX_VALUE;

    int index;

    public void simulateParticles(String path) {

        index = 0;

        particles = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(this::processInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        determineSolution();

    }

    void determineSolution() {

        for (int i = 0; i < 1000; i++) {
            for (Particle p : particles) {
                p.simulateTick();
            }
        }
        System.out.println("Finished ticks");

        closest = Long.MAX_VALUE;

        for (Particle p : particles) {
            long distance = p.determineManhatanDistance();
            if (distance > 0 && distance < closest) {
                System.out.println("Particle of index: " + p.id + " closest distance: " + distance);
                closest = distance;
            }
        }

    }

    private void processInput(String s) {
        int x = Integer.parseInt(s.substring(s.indexOf("<") + 1, s.indexOf(",")));
        int yStart = s.indexOf(",") + 1;
        int yEnd = s.indexOf(",", yStart);
        int y = Integer.parseInt(s.substring(yStart, yEnd));
        int pEnd = s.indexOf(">");
        int z = Integer.parseInt(s.substring(yEnd +1, pEnd));

        Coordinates position = new Coordinates(x, y, z);

        int xVEnd =  s.indexOf(",", pEnd + 2);
        x = Integer.parseInt(s.substring(s.indexOf("<", pEnd) + 1, xVEnd));
        yStart = s.indexOf(",", xVEnd) + 1;
        yEnd = s.indexOf(",", yStart);
        y = Integer.parseInt(s.substring(yStart, yEnd));
        int vEnd = s.indexOf(">", xVEnd);
        z = Integer.parseInt(s.substring(yEnd +1, vEnd));

        Coordinates velocity = new Coordinates(x, y, z);

        int xAEnd =  s.indexOf(",", vEnd + 2);
        x = Integer.parseInt(s.substring(s.indexOf("<", vEnd) + 1, xAEnd));
        yStart = s.indexOf(",", xAEnd) + 1;
        yEnd = s.indexOf(",", yStart);
        y = Integer.parseInt(s.substring(yStart, yEnd));
        int aEnd = s.lastIndexOf(">");
        z = Integer.parseInt(s.substring(yEnd +1, aEnd));

        Coordinates acceleration = new Coordinates(x, y, z);

        Particle p = new Particle(position, velocity, acceleration);
        long distance = p.determineManhatanDistance();

        p.id = index;
        index++;
        if (distance < closest) {
            System.out.println("Particle of index: " + particles.size() + " closest distance: " + distance);
            closest = distance;
        }
        particles.add(p);
    }

}
