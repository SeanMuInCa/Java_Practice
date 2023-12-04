package assign2SDC000506980;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Q7Test
{

    @Test
    public void testDrawAsterisksSquare()
    {
        int n = 5;
        String expectedOutput = "* * * * * \r\n* *   * * \r\n*   *   * \r\n* *   * * \r\n* * * * * \r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Q7.drawAsterisksSquare(n);
        System.setOut(System.out);
        assertEquals(expectedOutput, outContent.toString());
    }
}


