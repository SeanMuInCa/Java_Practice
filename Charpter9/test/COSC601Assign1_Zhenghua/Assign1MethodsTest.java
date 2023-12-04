package COSC601Assign1_Zhenghua;

import static org.junit.jupiter.api.Assertions.*;

class Assign1MethodsTest
{
    int[] a = { 3, 19, 22, 14, 7, 8 ,9 };
    int[] a1 = {5,6,3,4,1,2};
    int[] b = { 12, 7, 2, 8, 4 };
    int[] c = {1,1,2,3,3,4,5,5};
    int[] c1 = {5,5,4,3,3,2,1,1};
    int[] ab =  {3, 19, 22, 14, 9};

    @org.junit.jupiter.api.Test
    void arrayMedium()
    {
        assertEquals(Assign1Methods.arrayMedium(a),9);
        assertEquals(Assign1Methods.arrayMedium(a1),3);
    }

    @org.junit.jupiter.api.Test
    void getOddValues()
    {
        assertArrayEquals(Assign1Methods.getOddValues(a),b);
    }

    @org.junit.jupiter.api.Test
    void add()
    {
    }

    @org.junit.jupiter.api.Test
    void joinArray()
    {
        assertArrayEquals(Assign1Methods.joinArray(a,b), c1);
    }

    @org.junit.jupiter.api.Test
    void insertSort()
    {
    }

    @org.junit.jupiter.api.Test
    void arrayDiff()
    {
        assertArrayEquals(Assign1Methods.arrayDiff(a,b), ab);
    }

    @org.junit.jupiter.api.Test
    void binarySearch()
    {
    }

    @org.junit.jupiter.api.Test
    void subtractMatrices()
    {
    }

    @org.junit.jupiter.api.Test
    void pallPrimeInt()
    {
    }

    @org.junit.jupiter.api.Test
    void isPrime()
    {
    }

    @org.junit.jupiter.api.Test
    void isPalindromic()
    {
    }

    @org.junit.jupiter.api.Test
    void sumArrayRows()
    {
    }

    @org.junit.jupiter.api.Test
    void sumSingleRow()
    {
    }

    @org.junit.jupiter.api.Test
    void isCons4()
    {
    }

    @org.junit.jupiter.api.Test
    void cut()
    {
    }

    @org.junit.jupiter.api.Test
    void checkRows()
    {
    }

    @org.junit.jupiter.api.Test
    void checkOneRow()
    {
    }

    @org.junit.jupiter.api.Test
    void checkCols()
    {
    }

    @org.junit.jupiter.api.Test
    void checkDiags()
    {
    }
}