import static org.junit.jupiter.api.Assertions.*;

class HelperTest
{

    @org.junit.jupiter.api.Test
    void isPrime()
    {
        assertTrue(Helper.isPrime(2));
        assertTrue(Helper.isPrime(3));
        assertTrue(Helper.isPrime(5));
        assertTrue(Helper.isPrime(7));
        assertTrue(Helper.isPrime(11));
        assertTrue(Helper.isPrime(13));
        assertFalse(Helper.isPrime(4));
        assertFalse(Helper.isPrime(0));
    }
    @org.junit.jupiter.api.Test
    void getRandomNumber()
    {
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
        assertTrue(Helper.getRandomNumber(0,9)>=0 && Helper.getRandomNumber(0,9) <=9);
    }
}