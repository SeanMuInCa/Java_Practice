package TestCollection;

import java.util.ArrayList;
import java.util.Collection;

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
 * 随机30个小写字母，并查找出现某个字母多少次
 */
public class Exe1
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            list.add((char) (Math.random() * 26 + 97) + "");
        }

        System.out.println(list);
        System.out.println("a: " + listTest(list, "a"));
        System.out.println("b: " + listTest(list, "b"));
        System.out.println("c: " + listTest(list, "c"));
        System.out.println("x: " + listTest(list, "x"));
    }
    public static int listTest(Collection list , String s){
        int counter = 0;
        for(Object o : list){
            if(o.equals(s)){
                counter++;
            }
        }
        return counter;
    }
}
