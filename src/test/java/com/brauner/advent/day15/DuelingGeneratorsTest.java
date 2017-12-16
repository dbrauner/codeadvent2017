package com.brauner.advent.day15;

import org.junit.Test;

public class DuelingGeneratorsTest {
	@Test
	public void compareGeneratorsTest() throws Exception {
		DuelingGenerators generators = new DuelingGenerators();

		System.out.println("result: " + generators.compareGenerators(65, 8921));

	}

	@Test
	public void compareGeneratorsWithCriteriaTest() throws Exception {
		DuelingGenerators generators = new DuelingGenerators();

		System.out.println("result: " + generators.compareGeneratorsWithCriteria(65, 8921));

	}

	@Test
	public void compareGeneratorsReal() throws Exception {
		DuelingGenerators generators = new DuelingGenerators();

		System.out.println("result: " + generators.compareGenerators(116, 299));

	}

	@Test
	public void compareGeneratorsWithCriteriaReal() throws Exception {
		DuelingGenerators generators = new DuelingGenerators();

		System.out.println("result: " + generators.compareGeneratorsWithCriteria(116, 299));

	}

}