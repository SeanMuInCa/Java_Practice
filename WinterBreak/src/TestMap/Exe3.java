package TestMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2024/3/17 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe3
{
    public static void main(String[] args)
    {
        Map<Character, Integer> map = new HashMap<>();
        String str = "fdsajfoiweqhboinvlkqnoiuwehqirojwe";
        int count = 1;
        for (char c : str.toCharArray())
        {
            if(map.containsKey(c)){
                count = map.get(c);
                count++;
            }
            map.put(c,count);
        }
        System.out.println(map);
    }
}
