package com.brauner.advent.day8;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterInstructionsTest {
	@Test
	public void evaluateLargestValueInRegisters() throws Exception {

		RegisterInstructions instructions =  new RegisterInstructions();
		System.out.println("Greater value: " + instructions.evaluateLargestValueInRegisters("src/test/resources/registerTest.txt"));

		instructions =  new RegisterInstructions();
		System.out.println("Greater value: " + instructions.evaluateLargestValueInRegisters("src/test/resources/register.txt"));
	}

}