package TestCollection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 获取指定个随机数，但是不能重复
 */
public class Exe3
{
    public static void main(String[] args)
    {
        final int LENGTH = 10;
        final int COUNT = 20;
        Set set = new HashSet();
        while (set.size() < LENGTH){
            set.add(new Random().nextInt(COUNT) + 1);
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
