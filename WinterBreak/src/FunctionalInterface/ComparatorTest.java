package FunctionalInterface;

import org.junit.Test;

import java.util.Comparator;

/**
 * Purpose:             FunctionalInterface<br />
 * Data Submitted:      2024/2/12 <br />
 * Assignment Number:    FunctionalInterface<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          FunctionalInterface <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ComparatorTest
{
    @Test
    public void test(){
        Comparator<Integer> c = new Comparator<>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1-o2;
            }
        };

        Comparator<Integer> c1 = (o1,o2) -> o1-o2;
    }
}
