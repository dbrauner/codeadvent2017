package com.brauner.advent.day15;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class DuelingGenerators {

	long FACTOR_A = 16807;
	long FACTOR_B = 48271;

	int LIMIT = 40000000;

	int LIMIT_PART2 = 5000000;

	long DIVISOR = 2147483647;

	public int compareGenerators(int initA, int initB) {

		long generatorA = initA;
		long generatorB = initB;
		int totalEqual = 0;
		System.out.println("--Gen. A--  --Gen. B--");
		for (int i = 0; i < LIMIT; i++) {
			generatorA = Math.floorMod(generatorA * FACTOR_A, DIVISOR);
			generatorB = Math.floorMod(generatorB * FACTOR_B, DIVISOR);

			String binaryA = Long.toBinaryString(generatorA);
			String binaryB = Long.toBinaryString(generatorB);

			binaryA = StringUtils.leftPad(binaryA, 32, "0");
			binaryB = StringUtils.leftPad(binaryB, 32, "0");
			if (binaryA.substring(16).equals(binaryB.substring(16))) {
				totalEqual++;
			}

		}

		return totalEqual;

	}

	public int compareGeneratorsWithCriteria(int initA, int initB) {


		long generatorA = initA;
		long generatorB = initB;
		int totalEqual = 0;
		ArrayList<Long> generatorAList = new ArrayList<>();
		ArrayList<Long> generatorBList = new ArrayList<>();
		System.out.println("--Gen. A--  --Gen. B--");
		for (int i = 0; generatorAList.size() < LIMIT_PART2 || generatorBList.size() < LIMIT_PART2; i++) {
			generatorA = Math.floorMod(generatorA * FACTOR_A, DIVISOR);
			generatorB = Math.floorMod(generatorB * FACTOR_B, DIVISOR);

			if (Math.floorMod(generatorA, 4) == 0)
				generatorAList.add(generatorA);

			if (Math.floorMod(generatorB, 8) == 0)
				generatorBList.add(generatorB);
		}

		for (int i = 0; i < LIMIT_PART2; i++) {
			//System.out.println(generatorAList.get(i)  + "  " + generatorBList.get(i));

			String binaryA = Long.toBinaryString(generatorAList.get(i));
			String binaryB = Long.toBinaryString(generatorBList.get(i));

			binaryA = StringUtils.leftPad(binaryA, 32, "0");
			binaryB = StringUtils.leftPad(binaryB, 32, "0");
			if (binaryA.substring(16).equals(binaryB.substring(16))) {
				System.out.println("equal in index: " + i);
				totalEqual++;
			}

		}

		return  totalEqual;
	}


}
