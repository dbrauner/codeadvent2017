package com.brauner.advent.day22;

import java.util.LinkedList;

/**
 * Created by douglas on 31/12/2017.
 */
public class GridLinked {

    LinkedList<LinkedList<Character>> map;

    int x;

    int y;

    int currentSize;

    int infected;

    public GridLinked() {
        x = y = 0;
        currentSize = 0;
        infected = 0;
        map = new LinkedList<>();
    }

    public Character get(Integer xFactor, Integer yFactor) {

        if (xFactor + x >= 0 && xFactor + x < map.size() && yFactor + y >= 0 && yFactor + y < map.size() ) {
            x += xFactor;
            y += yFactor;
            return getElement(x, y);
        }
        currentSize++;
        if (xFactor + x < 0) {
            addColumnFirst();
            y++;
            map.addFirst(initializeList());
        }
        if (yFactor + y < 0) {
            addColumnFirst();
            map.add(initializeList());
        }
        if (xFactor + x >= map.size()) {
            addColumnLast();
            x++;
            map.add(initializeList());
        }
        if (yFactor + y >= map.size()) {
            addColumnLast();
            y++;
            map.add(initializeList());
        }
        return getElement(x, y);
    }

    private void addColumnFirst() {
        for (LinkedList<Character> line : map) {
            line.addFirst('.');
        }
    }

    private void addColumnLast() {
        for (LinkedList<Character> line : map) {
            line.add('.');
        }
    }

    public Character getElement(int x, int y) {
        return map.get(x).get(y);
    }

    public LinkedList<Character> initializeList() {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < currentSize; i++) {
            list.add('.');
        }
        return list;
    }

    public void print(int xFactor, int yFactor) {

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.size(); j++) {
                if (i == xFactor + x && j == yFactor + y) {
                    System.out.print(this.getElement(i, j) + "<");
                } else
                    System.out.print(this.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("With " + infected + " infected.");
    }
}
