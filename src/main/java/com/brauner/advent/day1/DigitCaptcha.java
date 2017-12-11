package com.brauner.advent.day1;

import java.util.ArrayList;

public class DigitCaptcha {

	public String sumMatchingDigits(String list) {

		char [] digitsInChar = list.toCharArray();
		Integer result = 0;

		ArrayList<Integer> digits = new ArrayList<Integer>();
		for (char digit : digitsInChar) {
			digits.add(Integer.parseInt(String.valueOf(digit)));
		}
		Integer firstDigit = digits.get(0);

		for (int i = 1; i < digits.size(); i++) {
			if (i == 1 && digits.get(i).equals(digits.get(0))) {
				result += digits.get(0);
				continue;
			}
			if (digits.get(i).equals(digits.get(i - 1))) {
				result += digits.get(i);
			}
		}
		Integer lastDigit = digits.get(digits.size() - 1);
		if (firstDigit == lastDigit) {
			result += lastDigit;
		}
		return result.toString();
	}

	public String sumHalfwayDigits(String list) {

		char [] digitsInChar = list.toCharArray();
		Integer result = 0;

		ArrayList<Integer> digits = new ArrayList<Integer>();
		for (char digit : digitsInChar) {
			digits.add(Integer.parseInt(String.valueOf(digit)));
		}

		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i).equals(getHalfwayNumber(digits, i))) {
				result += digits.get(i);
			}
		}
		return result.toString();
	}

	private int getHalfwayNumber(ArrayList<Integer> digits, int index) {
		int halfway = 0;
		if (index >= digits.size() / 2) {
			halfway = digits.get(index - digits.size() / 2);
		} else
			halfway = digits.get(index + digits.size() / 2);
		return halfway;
	}


}
