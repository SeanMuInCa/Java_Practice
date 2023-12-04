package mashibing;

import java.util.HashMap;

/**
 * Purpose:             mashibing<br />
 * Data Submitted:      2023/11/25 <br />
 * Assignment Number:    mashibing<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestHashMap
{
    public static void main(String[] args)
    {
        //key-value
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1001, "raina1");
        hm.put(1002, "raina2");
        hm.put(1003, "raina3");
        hm.put(1004, "raina4");
        hm.put(1005, "raina5");
        System.out.println(hm);
    }
}
