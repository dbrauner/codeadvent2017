package com.brauner.advent.day11;

/**
 * Created by douglas on 12/12/2017.
 */
public class HexGridMaze {

    Hex hexKid;

    int furthest;

    public int determineStepsShortestPath(String input) {

        hexKid = new Hex();

        furthest = 0;

        String[] steps = input.split(",");

        for (String step : steps) {
            calculateStep(step);
            int distance = determineDistance();
            if (distance > furthest) furthest = distance;
        }

        System.out.println("Furthest : " + furthest);
        return determineDistance();
    }

    private int determineDistance() {
        return (Math.abs(0 - hexKid.x) + Math.abs(0 - hexKid.y) + Math.abs(0 - hexKid.z)) / 2;
    }

    private void calculateStep(String step) {
        if (step.equals("n")) {
            hexKid.z--;
            hexKid.y++;
            return;
        }
        if (step.equals("ne")) {
            hexKid.z--;
            hexKid.x++;
            return;
        }
        if (step.equals("s")) {
            hexKid.z++;
            hexKid.y--;
            return;
        }
        if (step.equals("se")) {
            hexKid.y--;
            hexKid.x++;
            return;
        }
        if (step.equals("sw")) {
            hexKid.x--;
            hexKid.z++;
            return;
        }
        if (step.equals("nw")) {
            hexKid.y++;
            hexKid.x--;
            return;
        }
        System.out.println("shit happened");

    }
}
