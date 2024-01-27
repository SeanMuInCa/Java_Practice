package Lab3;

/**
 * Purpose:             Lab3<br />
 * Data Submitted:      2024/1/27 <br />
 * Assignment Number:    Lab3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class DataLengthNotFormatException extends Exception
{
    public DataLengthNotFormatException()
    {
        super("The data you input does not match!");
    }

    public DataLengthNotFormatException(String message)
    {
        super(message);
    }
}
