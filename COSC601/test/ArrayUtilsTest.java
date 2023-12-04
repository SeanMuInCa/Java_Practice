

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    int[] testArray = {2,5,9,44,7,33,51,16,178};
    int[] testArray2 = {2,5,9,44,7,33,7,51,16,7,178,7};
    int[] testReverseArrayExpected = {178,16,51,33,7,44,9,5,2};
    int[] testOddArrayExpected = {5,9,7,33,51};
    int[] testArrayCopyArrExpected = {2,5,9,44,7,33,51,16,178};
    int[] testArrayCopySrc = {43,43,546,687,643,345,534,243,67};
    int[] testArrayCopyDest = {9,9,9,9,9,9,9,9,9};
    int[] testArrayCopyExpected = {43,43,546,687,643,345,9,9,9};
    int[] testArrayReduceExpected = {2,5,9,44,7};
    int[] testArrayGrowExpected = {2,5,9,44,7,33,51,16,178,0,0};

    @DisplayName("Test that the Max method functions correctly given correct and incorrect input")
    @Test
    public void testMax(){
        assertEquals(178,ArrayUtils.max(testArray));
        assertNotEquals(2, ArrayUtils.max(testArray));
    }

    @DisplayName("Test that the Min method functions correctly given correct and incorrect input")
    @Test
    public void testMin(){
        assertNotEquals(178,ArrayUtils.min(testArray));
        assertEquals(2, ArrayUtils.min(testArray));
    }

    @DisplayName("Test that the countOdd method functions correctly given an array with an odd number of elements")
    @Test
    public void testCountOdd(){
        assertEquals(5,ArrayUtils.countOdd(testArray));
    }

    @DisplayName("Test that the toString method returns correct string representation of an Array")
    @Test
    public void testToString(){
        assertEquals("[2, 5, 9, 44, 7, 33, 51, 16, 178]", ArrayUtils.toString(testArray));
    }

    @DisplayName("Test that the reverseToString method returns correct reversesd string representation of an Array")
    @Test
    public void testRevToString(){
        assertEquals("[178, 16, 51, 33, 7, 44, 9, 5, 2]", ArrayUtils.reverseToString(testArray));
    }

    @DisplayName("Test that the toString method returns correct string representation of an Array")
    @Test
    public void testTimesOccur(){
        assertEquals(4, ArrayUtils.timesOccur(testArray2,7));
    }

    @DisplayName("Test that the reverse method returns a reversed version of a given array")
    @Test
    public void testReverse(){
        assertArrayEquals(testReverseArrayExpected,ArrayUtils.reverse(testArray));
    }

    @DisplayName("Test that the oddValues method returns an array of just odd values from an inputted array")
    @Test
    public void testOddValues(){
        assertArrayEquals(testOddArrayExpected,ArrayUtils.oddValues(testArray));
    }

    @DisplayName("Test that the copyArr method returns a simple copy of a given array")
    @Test
    public void testCopyArr(){
        assertArrayEquals(testArrayCopyArrExpected,ArrayUtils.copyArr(testArray));
    }

    @DisplayName("Test that the copy method returns a specific copy of a given array")
    @Test
    public void testCopy(){
        ArrayUtils.copy(testArrayCopySrc,testArrayCopyDest,6);
        assertArrayEquals(testArrayCopyExpected, testArrayCopyDest);
    }

    @DisplayName("Test that the reduce method returns a version of a given array which has been reduced by a specific amount")
    @Test
    public void testReduce(){
        assertArrayEquals(testArrayReduceExpected,ArrayUtils.reduce(testArray,5));
    }

    @DisplayName("Test that the grow method returns a version of a given array which is increased by a specific amount")
    @Test
    public void testGrow(){
        assertArrayEquals(testArrayGrowExpected,ArrayUtils.grow(testArray,2));
    }

}
