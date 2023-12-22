package TestGenerics;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2023/12/22 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe2
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Random().nextInt(100));
        list.add(new Random().nextInt(100));
        list.add(new Random().nextInt(100));
        list.add(new Random().nextInt(100));
        list.add(new Random().nextInt(100));
        for(Integer i : list){
            System.out.println(i);
        }

        list.removeIf(new Predicate<Integer>() {//虽然没学过，但是猜出来应该是这么写

            @Override
            public boolean test(Integer integer)
            {
                return integer % 2 == 0;
            }
        });
        System.out.println(list);
    }
}
