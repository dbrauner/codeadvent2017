package com.brauner.checksum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorruptionChecksumTest {
	@Test
	public void differenceChecksum() throws Exception {

		CorruptionChecksum corruptionChecksum = new CorruptionChecksum();

		String input = "5 1 9 5\n" + "7 5 3\n" + "2 4 6 8";
		System.out.println(corruptionChecksum.differenceChecksum(input));

	}

}