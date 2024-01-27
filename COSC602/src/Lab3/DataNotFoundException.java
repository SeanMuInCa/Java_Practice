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
public class DataNotFoundException extends Exception
{
    public DataNotFoundException()
    {
        super("Data not found!");
    }

    public DataNotFoundException(String message)
    {
        super(message);
    }
}
