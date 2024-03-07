package Lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Purpose:             Lab1<br />
 * Data Submitted:      2024/3/6 <br />
 * Assignment Number:    Lab1<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          Lab1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
class StringCalculatorTest
{
//    @Test
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown()
//    {
//        assertThrows(RuntimeException.class, () -> {
//            StringCalculator.add("1,2,3");
//        });
//    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown()
    {
        StringCalculator.add("1,2");
        assertTrue(true);
    }

    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("1,X");
        });
        //System.out.println(thrown.getMessage());
    }

    @Test
    public final void whenEmptyStringIsUsedThenZeroIsReturned()
    {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(0, StringCalculator.add("   "));
    }

    @Test
    public final void whenOneNumberIsUsedThenThatNumberIsReturned()
    {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenTheirSumIsReturned()
    {
        assertEquals(3 + 6, StringCalculator.add("3,6"));
    }


    @Test
    public final void
    whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums()
    {
        assertEquals(3 + 6 + 15 + 18 + 46 + 33,
                StringCalculator.add("3,6,15,18,46,33"));
    }

    @Test
    public final void
    whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums()
    {
        assertEquals(3 + 6 + 15, StringCalculator.add("3,6\n15"));
        assertEquals(3 + 6 + 15, StringCalculator.add("3\n6\n15"));
    }

    @Test
    public final void
    whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers()
    {
        assertEquals(3 + 6 + 15,
                StringCalculator.add("//;\n3;6;15"));
        assertEquals(3 + 6 + 15,
                StringCalculator.add("//&\n3&6&15"));
//        assertEquals(3 + 6 + 15,
//                StringCalculator.add("//+\n3+6+15"));
    }

    @Test
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown()
    {
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("3,-6,15,18,46,33");
        });
        assertEquals("Negatives are not allowed: [-6]",
                e.getMessage());
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown()
    {
        RuntimeException exception = null;

        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        }
        catch (RuntimeException e)
        {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Negatives are not allowed: [-6, -18]",
                exception.getMessage());
    }


    // Requirement 8: Numbers bigger than 1000 should be ignored.
    // For instance, adding 2 + 1001 = 2
    @Test
    public final void whenNumbersAbove1000AreUsedThenTheyAreIgnored()
    {
        assertEquals(2, StringCalculator.add("1001,2"));
        assertNotEquals(2 + 1001, StringCalculator.add("2,1001"));
        assertEquals(3 + 1000 + 6,
                StringCalculator.add("3,1000,1001,6,1234"));
    }

    // Requirement 9: Delimiters can be of any length
    // The following format should be allowed: "//[delimiter]\n"
    // Example: "//[--]\n1--2--3" should return 6

    // Requirement 10: Allow multiple delimiters
    // The following format should be allowed: "//[delim1][delim2]\n"
    // Example: "//[-][%]\n1-2%3" should return 6

    // Requirement 11: Make sure that you can also handle multiple delimiters
    // with length longer than one character
}