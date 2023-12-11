package Test06;

/**
 * Purpose:             Test06<br />
 * Data Submitted:      2023/12/10 <br />
 * Assignment Number:    Test06<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test06 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GFTest
{
    public static void main(String[] args)
    {
        GF gf = GF.getInstance();
        GF gf2 = GF.getInstance();
        System.out.println(gf == gf2);
    }
}
