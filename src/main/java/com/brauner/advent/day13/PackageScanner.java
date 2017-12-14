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

	HashMap<Integer, Layer> layers;
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
			if (layers.containsKey(i)) {
				Layer layer = layers.get(i);
				if (layer.scanning == 0 ) {
					severity += i * layer.lenght;
				}
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


		HashMap<Integer, Layer> copy = this.cloneMap(layers);

		while(true) {
			delays ++;
			for (Layer layer : layers.values()) {
				layer.direction = 0;
			}

			layers = cloneMap(copy);
			scan();

			copy = cloneMap(layers);

			for (int i = 0; i <= maxValue; i++) {
				scan();
				if (layers.containsKey(i)) {
					Layer layer = layers.get(i);
					if (layer.scanning == 0) {
						severity = 1;
						break;
					}
				}
			}
			if (severity == 0) {
				break;
			}

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

		Layer layer = new Layer(0, depth, range, 0);
		layers.put(depth, layer);
		maxValue = depth;
	}

	private void scan() {
		for (Layer layer : layers.values()) {
			nextScanStep(layer);
		}

	}

	private HashMap<Integer, Layer> cloneMap(Map<Integer, Layer> layerMap) {
		HashMap<Integer, Layer> copy = new HashMap<>();
		for (Layer layer : layerMap.values()) {
			copy.put(layer.depth, new Layer(layer));
		}
		return copy;
	}

	private void nextScanStep(Layer layer) {
		if (layer.direction == 0) {
			layer.scanning = 0;
			layer.direction = UP;
			return;
		}
		if (layer.direction == UP) {
			if (layer.scanning < layer.lenght - 1) {
				layer.scanning++;
				return;
			}
			layer.scanning--;
			layer.direction = DOWN;
			return;
		}
		if (layer.scanning > 0) {
			layer.scanning --;
			layer.direction = DOWN;
			return;
		}
		layer.scanning++;
		layer.direction = UP;
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
