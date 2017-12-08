package day3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by douglas on 08/12/2017.
 */
public class SpiralMemoryTest {

    @Test
    public void calculateTaxicabDistanceTest() {
        SpiralMemory spiralMemory = new SpiralMemory();

        int testInput = 1;
        int result = spiralMemory.calculateTaxicabDistance(testInput);
        System.out.println("result " + result + " for input " + testInput);
        //Assert.assertEquals(result, 0);

        testInput = 12;
        result = spiralMemory.calculateTaxicabDistance(testInput);
        System.out.println("result " + result + " for input " + testInput);
//        Assert.assertEquals(result, 3);

        testInput = 23;
        result = spiralMemory.calculateTaxicabDistance(testInput);
        System.out.println("result " + result + " for input " + testInput);
//        Assert.assertEquals(result, 2);

        testInput = 1024;
        result = spiralMemory.calculateTaxicabDistance(testInput);
        System.out.println("result " + result + " for input " + testInput);
//        Assert.assertEquals(result, 31);

        testInput = 277678;
        result = spiralMemory.calculateTaxicabDistance(testInput);
        System.out.println("result " + result + " for input " + testInput);



    }

    @Test
    public void calculateFirstLargerValueInStressedSpiralTest (){
        SpiralMemory spiralMemory = new SpiralMemory();
        int nextValue = spiralMemory.calculateFirstLargerValueInStressedSpiral(5);
        System.out.println("proximo para 5 = " + nextValue);

        spiralMemory = new SpiralMemory();
        nextValue = spiralMemory.calculateFirstLargerValueInStressedSpiral(140);
        System.out.println("proximo para 140 = " + nextValue);

        spiralMemory = new SpiralMemory();
        nextValue = spiralMemory.calculateFirstLargerValueInStressedSpiral(277678);
        System.out.println("proximo para 140 = " + nextValue);


    }

}