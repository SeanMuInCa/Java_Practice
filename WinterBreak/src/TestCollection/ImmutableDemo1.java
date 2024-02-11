package TestCollection;

import java.util.List;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2024/2/11 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ImmutableDemo1
{
    //不可变的集合list，set,map都有of方法
    public static void main(String[] args)
    {

        //不可修改
        List<String> family = List.of("raina", "rainba", "rainma");
        for (String s : family)
        {
            System.out.println(s);
        }
        //family.add("zzs");


    }
}
