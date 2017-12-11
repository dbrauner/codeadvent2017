package com.brauner.advent.day6;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by douglas on 09/12/2017.
 */
public class MemoryReallocationTest {

    @Test
    public void balanceBankListTest() {
        MemoryReallocation memoryReallocation = new MemoryReallocation();

        String testInput = "0\t2\t7\t0";
        int[] list = Arrays.stream(testInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("loops : " + memoryReallocation.balanceBankList(list));

        testInput = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14";

        list = Arrays.stream(testInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("loops : " + memoryReallocation.balanceBankList(list));

    }

    @Test
    public void balanceBankListWithLoopSizeTest() {
        MemoryReallocation memoryReallocation = new MemoryReallocation();

        String testInput = "0\t2\t7\t0";
        int[] list = Arrays.stream(testInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("loops : " + memoryReallocation.balanceBankListWithLoopSize(list));

        testInput = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14";

        list = Arrays.stream(testInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("loops : " + memoryReallocation.balanceBankListWithLoopSize(list));

    }

}