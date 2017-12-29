package com.brauner.advent.day14;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class DiskDefragTest {
	@Test
	public void squaresUsedByHash() throws Exception {
		DiskDefrag diskDefrag = new DiskDefrag();

		System.out.println("result: " + diskDefrag.squaresUsedByHash("flqrgnkx"));

		diskDefrag = new DiskDefrag();

		System.out.println("result: " + diskDefrag.squaresUsedByHash("nbysizxe"));
	}

}