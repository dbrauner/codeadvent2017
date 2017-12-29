package com.brauner.advent.day14;

import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;

import com.brauner.advent.day10.KnotHash;

public class DiskDefrag {

	int totalSquares;

	Square[][] squares;

	int line;
	int currentRegion;

	public int squaresUsedByHash(String input) {

		totalSquares = 0;
		squares = new Square[128][128];
		currentRegion = 0;

		for (int i = 0; i < 128; i++) {
			line = i;
			processHashInput(input + "-" + i);
		}
		System.out.println("total used: " + totalSquares);

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (squares[i][j].used) {
					int region = findAdjacentRegion(i, j);
					if (region > 0 ) {
						squares[i][j].region = region;
						fillAdjacentRegions(i, j, region);
					}
					else {
						currentRegion++;
						squares[i][j].region = currentRegion;
						fillAdjacentRegions(i, j, currentRegion);
					}
				}
			}
		}

		System.out.println("Total of regions: " + currentRegion);

		return  totalSquares;
	}

	private void fillAdjacentRegions(int i, int j, int region) {
		if (j > 0 && squares[i][j -1].used && squares[i][j -1].region == 0) {
			squares[i][j -1].region = region;
			fillAdjacentRegions(i, j -1, region);
		}

		if (j < 127 && squares[i][j + 1].used && squares[i][j + 1].region == 0) {
			squares[i][j + 1].region = region;
			fillAdjacentRegions(i, j+1, region);
		}

		if (i > 0 && squares[i -1][j].used && squares[i -1][j].region == 0) {
			squares[i -1][j].region = region;
			fillAdjacentRegions(i-1,j, region);
		}

		if (i < 127 && squares[i + 1][j].used && squares[i + 1][j].region == 0) {
			squares[i + 1][j].region = region;
			fillAdjacentRegions(i+1,j, region);
		}

	}

	private int findAdjacentRegion(int i, int j) {

		if (j > 0 && squares[i][j -1].region > 0)
			return squares[i][j -1].region;
		if (j < 127 && squares[i][j + 1].region > 0)
			return squares[i][j + 1].region;
		if (i > 0 && squares[i -1][j].region > 0)
			return squares[i -1][j].region;
		if (i < 127 && squares[i + 1][j].region > 0)
			return squares[i + 1][j].region;
		return 0;
	}

	private void processHashInput(String s) {

		KnotHash knotHash = new KnotHash();
		String hashValue  = knotHash.calculateHashWithASCII(s);
		//System.out.println("knot hash: " + hashValue + " for :" + s);

		String binaryValue = new BigInteger(hashValue, 16).toString(2);


		String binaryData = StringUtils.leftPad(binaryValue, 128, "0");

		countUSedSquares(binaryData);
		System.out.println(binaryData);
	}

	private void countUSedSquares(String binaryData) {
		char[] squares = binaryData.toCharArray();
		int column = 0;
		for (char square : squares) {
			if (square == '1') {
				this.squares[line][column] = new Square(true);
				totalSquares++;
			}
			else
				this.squares[line][column] = new Square(false);
			column++;
		}
	}

}
