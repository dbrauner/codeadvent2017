package com.brauner.advent.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class RegisterInstructions {

	Map<String, Integer> registerMap;

	Integer everGreat;

	public int evaluateLargestValueInRegisters(String inputPath) throws IOException {

		everGreat = 0;

		registerMap = new HashMap<>();

		try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

			stream.forEach(this::parseInstructionLine);
		}

		if (registerMap.containsKey("dec") || registerMap.containsKey("inc")) {
			System.out.println("shit!");
		}
		Integer greaterValue = Integer.MIN_VALUE;
		for (Integer mapValue : registerMap.values()) {
			if (mapValue > greaterValue)
				greaterValue = mapValue;
		}

		System.out.println("Ever great value: " + everGreat);
		return greaterValue;
	}

	private void parseInstructionLine(String line) {

		String name = this.parseRegisterName(line);

		Integer value = 0;

		if (registerMap.containsKey(name)) {
			value = registerMap.get(name);
		}

		Integer modifyValue = determineModifyValue(line);

		try {
			if (isConditionTrue(line)) {
				if (isIncrementOperation(line)) {
					value += modifyValue;
					System.out.println("inc " + name + " by " + modifyValue + " now is " + value);
				}
				else {
					value -= modifyValue;
					System.out.println("dec " + name + " by " + modifyValue + " now is " + value);
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (value > everGreat)
			everGreat = value;
		registerMap.put(name, value);
	}

	private Integer determineModifyValue(String line) {
		if (isIncrementOperation(line))
			return Integer.parseInt(line.substring(line.indexOf("inc") + 4, line.indexOf("if") - 1));
		return Integer.parseInt(line.substring(line.indexOf("dec") + 4, line.indexOf("if") -1 ));
	}

	private String parseRegisterName(String line) {
		return line.substring(0, line.indexOf(" "));
	}

	private boolean isIncrementOperation(String line) {
		return line.contains("inc");
	}

	private boolean isConditionTrue(String line) throws Exception {

		Condition condition = determineCondition(line);
		String registerCondition = determineRegisterCondition(line);

		Integer registerValue = 0;

		if (registerMap.containsKey(registerCondition)) {
			registerValue = registerMap.get(registerCondition);
		}

		Integer conditionValue = determineConditionValue(line);

		switch (condition) {
		case GREATER:
			return (registerValue > conditionValue);
		case LESS:
			return (registerValue < conditionValue);
		case GREATER_EQUAL:
			return (registerValue >=conditionValue);
		case EQUAL:
			return (Objects.equals(registerValue, conditionValue));
		case NOT_EQUAL:
			return (!Objects.equals(registerValue, conditionValue));
		case LESS_EQUAL:
			return (registerValue <=conditionValue);
		}
		System.out.println("shit happened");
		throw new Exception("shit");
	}

	private Integer determineConditionValue(String line) {
		return Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
	}

	private Condition determineCondition(String line) throws Exception {
		if (line.contains(">=")) return Condition.GREATER_EQUAL;
		if (line.contains("<=")) return Condition.LESS_EQUAL;
		if (line.contains("==")) return Condition.EQUAL;
		if (line.contains("!=")) return Condition.NOT_EQUAL;
		if (line.contains(">")) return Condition.GREATER;
		if (line.contains("<")) return Condition.LESS;
		throw new Exception("condition not found");

	}

	private String determineRegisterCondition(String line) {
		String subvalue = line.substring(line.indexOf("if ") + 3);
		return subvalue.substring(0, subvalue.indexOf(" "));
	}
}
