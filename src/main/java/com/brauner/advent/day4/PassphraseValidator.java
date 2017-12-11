package com.brauner.advent.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Stream;

public class PassphraseValidator {

    int validLines = 0;

    public int validatePassphraseFile(String inputPath) throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            stream.forEach(this::validatePassphrase);
        }
        return validLines;
    }

    private void validatePassphrase(String input) {
        String[] passphrase = input.split("\\s+");

        boolean valid = true;
        for (int i = 0; i < passphrase.length ; i++) {
            for (int j = 0; j < passphrase.length; j++) {
                if (i != j && passphrase[i].equals(passphrase[j]))
                    valid = false;
            }
        }
        if (valid)
            validLines++;
    }

    public int validateAnagramPassphraseFile(String inputFile) throws IOException {
        validLines = 0;
        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {

            stream.forEach(this::validateAnagramPassphrase);
        }
        return validLines;

    }

    private void validateAnagramPassphrase(String input) {
        String[] passphrase = input.split("\\s+");

        for (int i = 0; i < passphrase.length ; i++) {
            for (int j = 0; j < passphrase.length; j++) {
                if (i != j) {
                    if (isAnagram(passphrase[i], passphrase[j])) {
                        return;
                    }
                }
            }
        }
        validLines++;
    }

    private boolean isAnagram(String a, String b) {
        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> bList = new ArrayList<>();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        for (char char1 : aChar) {
            aList.add(String.valueOf(char1));
        }
        for (char char1 : bChar) {
            bList.add(String.valueOf(char1));
        }

        Collections.sort(aList);
        Collections.sort(bList);
        if (aList.size() != bList.size())
            return false;

        for (int i = 0; i < aList.size(); i++) {
            if (!Objects.equals(aList.get(i), bList.get(i)))
                return false;
        }
        return true;
    }

}
