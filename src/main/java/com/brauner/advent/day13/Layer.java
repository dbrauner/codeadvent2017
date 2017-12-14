package com.brauner.advent.day13;

/**
 * Created by douglas on 13/12/2017.
 */
public class Layer {

    int scanning;

    int depth;

    int lenght;

    int direction;

    public Layer() {
    }

    public int getDirection() {
        return direction;
    }

    public Layer(int scanning, int depth, int lenght, int direction) {
        this.scanning = scanning;
        this.depth = depth;
        this.lenght = lenght;
        this.direction = direction;
    }

    public Layer(Layer layer) {
        this.scanning = layer.scanning;
        this.depth = layer.depth;
        this.lenght = layer.lenght;
        this.direction = layer.direction;

    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getScanning() {
        return scanning;
    }

    public void setScanning(int scanning) {
        this.scanning = scanning;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
