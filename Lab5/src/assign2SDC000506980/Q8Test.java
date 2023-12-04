package assign2SDC000506980;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q8Test
{

    @Test
    void isPallyPrime()
    {
        assertTrue(Q8.isPallyPrime(131));
        assertFalse(Q8.isPallyPrime(1221));
        assertFalse(Q8.isPallyPrime(-131));
        assertFalse(Q8.isPallyPrime(0));
        assertFalse(Q8.isPallyPrime(1));
        assertFalse(Q8.isPallyPrime(9223372036854775807l));
        assertFalse(Q8.isPallyPrime(2222722222222222213l));
    }


    @Test
    void isPrime()
    {
        assertTrue(Q8.isPrime(2));
        assertTrue(Q8.isPrime(3));
        assertTrue(Q8.isPrime(5));
        assertTrue(Q8.isPrime(7));
        assertFalse(Q8.isPrime(4));
    }
}