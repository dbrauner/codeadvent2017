package com.brauner.advent.day10;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by douglas on 11/12/2017.
 */
public class KnotHash {

    private int SIZE = 256;

    int[] knotList = new int [SIZE];

    int skip = 0;

    int position = 0;

    public int calculateHash(String input) {
        initializeList();
        position = 0;
        skip = 0;

        String[] lenghts = input.split(",");

        for (String lenght : lenghts) {
            reverseList(Integer.parseInt(lenght));
        }
        return knotList[0] * knotList[1];
    }

    public String calculateHashWithASCII(String input) {
        initializeList();
        position = 0;
        skip = 0;

        char[] lenghts = input.toCharArray();

        ArrayList<String> lenghtAsc = new ArrayList<>();
        for (char lenght : lenghts) {
            String hex = String.valueOf((int) lenght);
            lenghtAsc.add(hex);
        }
        lenghtAsc.add("17");
        lenghtAsc.add("31");
        lenghtAsc.add("73");
        lenghtAsc.add("47");
        lenghtAsc.add("23");
        for (int i = 0; i < 64; i++) {
            for (String lenght : lenghtAsc) {
                reverseList(Integer.parseInt(lenght));
            }
        }
        return  determineXorValue(knotList);
    }

    public String determineXorValue(int[] list) {
        String result = "";
        for (int i = 0; i < 16; i++) {
            int xorValue = 0;
            for (int j = 0; j < 16; j++) {
                xorValue = xorValue ^ list[j + (i * 16)];
            }
            if (xorValue > 255) {
                System.out.println("shit!");
            }
            String value = Integer.toHexString(0x100 |xorValue).substring(1);
            result += value;
        }
        return result;
    }

    private void reverseList(int lenght) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < lenght; i++) {
            int index = position + i;
            while (index >= SIZE) {
                index -= SIZE;
            }
            if (index == 256) {
                System.out.println("shit");
            }
            linkedList.push(knotList[index]);
        }

        for (int i = 0; i < lenght; i++) {
            int index = position + i;
            while (index >= SIZE) {
                index -= SIZE;
            }
            knotList[index] = linkedList.pop();
        }
        position += lenght + skip;
        while (position >= SIZE) {
            position -= SIZE;
        }
        skip++;

    }

    private void initializeList() {
        for (int i = 0; i < SIZE; i++) {
            knotList[i] = i;
        }
    }
}
