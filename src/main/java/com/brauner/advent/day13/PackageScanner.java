package com.brauner.advent.day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PackageScanner {

	private static int UP = 1;
	private static int DOWN = 2;
	int maxValue = 0;
	int severity;

	Map<Integer, Integer[]> layers;
	int index;

	public int sneakThroughFirewall(String inputPath) throws IOException {
		layers = new HashMap<>();
		index = 0;
		severity = 0;
		try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

			stream.forEach(this::processLine);
		}

		for (int i = 0; i <= maxValue; i++) {
			scan();
			int positionStatus = 0;
			if (layers.containsKey(i)) {
				positionStatus = layers.get(i)[0];
			}
			if (positionStatus == UP || positionStatus == DOWN) {
				severity += i * layers.get(i).length;
			}
		}

		return severity;

	}

	public int sneakThroughFirewallWithoutBeingCaught(String inputPath) throws IOException {
		layers = new HashMap<>();
		index = 0;
		severity = 0;
		int delays = 0;
		boolean gotCaught = true;
		try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

			stream.forEach(this::processLine);
		}

		while(true) {
			for (Integer[] layer : layers.values()) {
				Arrays.fill(layer, 0);
			}

			for (int i = 0; i < delays; i++) {
				scan();
			}
			for (int i = 0; i <= maxValue; i++) {
				scan();
				int positionStatus = 0;
				if (layers.containsKey(i)) {
					positionStatus = layers.get(i)[0];
				}
				if (positionStatus == UP || positionStatus == DOWN) {
//					System.out.println("caught in index: " + i + "delay :" + delays);
					severity += 1;
				}
			}
			if (severity == 0) {
				break;
			}
			delays ++;
			severity = 0;
			if (delays == 0) {
				System.out.println("shit zero again!");
			}
			if (delays == 100 )
				System.out.println("100 mark!");
			if (delays == 1000 )
				System.out.println("mil mark!");
			if (delays == 10000 )
				System.out.println("10 million mark!");
			if (delays == 100000 )
				System.out.println("100 mil mark!");

			if (delays == 1000000 )
				System.out.println("1 million mark!");
			if (delays == 2000000)
				System.out.println("2 million mark!");
			if (delays == 3000000)
				System.out.println("3 million mark!");
			if (delays == 3870382)
				System.out.println("shit!!!");
		}
		return delays;
	}



	private void processLine(String s) {
		Integer depth = Integer.parseInt(s.substring(0, s.indexOf(":")));
		Integer range = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));

		Integer[] layer = new Integer[range];
		Arrays.fill(layer, 0);
		layers.put(depth, layer);
		maxValue = depth;
	}

	private void scan() {
		for (Integer[] layer : layers.values()) {
			int scanIndex = getScanIndex(layer);
			nextScanStep(layer, scanIndex);
		}

	}

	private void nextScanStep(Integer[] layer, int scanIndex) {
		if (layer[scanIndex] == 0) {
			layer[scanIndex] = UP;
			return;
		}
		if (layer[scanIndex] == UP) {
			layer[scanIndex] = 0;
			if (scanIndex < layer.length - 1) {
				scanIndex++;
				layer[scanIndex] = UP;
				return;
			}
			scanIndex--;
			layer[scanIndex] = DOWN;
			return;
		}
		layer[scanIndex] = 0;
		if (scanIndex > 0) {
			scanIndex--;
			layer[scanIndex] = DOWN;
			return;
		}
		scanIndex++;
		layer[scanIndex] = UP;
	}

	private int getScanIndex(Integer[] layer) {
		for (int i = 0; i < layer.length; i++) {
			if (layer[i] == UP || layer[i] == DOWN) {
				return i;
			}
		}
		return 0;
	}

}
