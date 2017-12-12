package com.brauner.advent.day9;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by douglas on 11/12/2017.
 */
public class StreamGroupFinderTest {

    @Test
    public void test () throws IOException {
        StreamGroupFinder finder = new StreamGroupFinder();
        String input = "{}";
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{{}}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{},{}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{{},{},{{}}}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{<a>,<a>,<a>,<a>}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{<ab>},{<ab>},{<ab>},{<ab>}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{<!!>},{<!!>},{<!!>},{<!!>}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "{{<!>},{<!>},{<!>},{<a>}}";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        System.out.println("groups: " + finder.findValidGroups(stream));

        try (Stream<String> streaming = Files.lines(Paths.get("src/test/resources/groups.txt"))) {

            streaming.forEach(this::parseFile);
        }

    }

    private void parseFile(String content) {
        StreamGroupFinder finder = new StreamGroupFinder();
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8.name()));
            System.out.println("groups: " + finder.findValidGroups(stream));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void garbageCollected() throws IOException {
        StreamGroupFinder finder = new StreamGroupFinder();
        String input = "<>";
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<random characters>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<<<<>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<{!>}>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<!!>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<!!!>>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        input = "<{o\"i!a,<{i<a>";
        stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.out.println("groups: " + finder.findValidGroups(stream));

        try (Stream<String> streaming = Files.lines(Paths.get("src/test/resources/groups.txt"))) {

            streaming.forEach(this::parseFile);
        }
    }


}