package assign2SDC000506980;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q9Test
{
    @Test
    void isValid()
    {
        assertTrue(Q9.isValid(4388576018410707l));
        assertFalse(Q9.isValid(4388576018402626l));
    }

    @Test
    void sumOfDoubleEvenPlaces()
    {
        assertEquals(37, Q9.sumOfDoubleEvenPlaces(4388576018402626l));
        assertEquals(29, Q9.sumOfDoubleEvenPlaces(4388576018410707l));
    }

    @Test
    void getSumDigits()
    {
        assertEquals(4, Q9.getSumDigits(4));
        assertEquals(3, Q9.getSumDigits(12));
    }

    @Test
    void sumOfOddPlaces()
    {
        assertEquals(38, Q9.sumOfOddPlaces(4388576018402626l));
        assertEquals(41, Q9.sumOfOddPlaces(4388576018410707l));
    }

    @Test
    void prefixCorrect()
    {
        assertTrue(Q9.prefixCorrect(4388576018410707l, 4));
        assertTrue(Q9.prefixCorrect(5388576018410707l, 5));
        assertTrue(Q9.prefixCorrect(6388576018410707l, 6));
        assertTrue(Q9.prefixCorrect(3788576018410707l, 37));
        assertFalse(Q9.prefixCorrect(2288576018410707l, 4));
        assertFalse(Q9.prefixCorrect(2288576018410707l, 5));
        assertFalse(Q9.prefixCorrect(2288576018410707l, 6));
        assertFalse(Q9.prefixCorrect(2288576018410707l, 37));
    }

    @Test
    void getSize()
    {
        assertEquals(16, Q9.getSize(4388576018402626l));
        assertEquals(1, Q9.getSize(0));
    }
}