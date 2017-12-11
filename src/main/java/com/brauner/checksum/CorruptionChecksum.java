package com.brauner.checksum;

import java.util.ArrayList;
import java.util.Collections;

public class CorruptionChecksum {

	public String differenceChecksum(String list) {
		Integer checksum = 0;
		String[] inputList =  list.split("\\t");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (String inputValue : inputList) {
			numbers.add(Integer.parseInt(inputValue));
		}
		Collections.sort(numbers);
		checksum += Math.abs(numbers.get(0) - numbers.get(numbers.size() - 1));
		return checksum.toString();
	}
}
