package TestStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/2/13 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Practice1
{
    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        String[] arr1 = {"1","2","3","4","5","6","7"};
        List<String> list = Arrays.asList(arr1);
        System.out.println(list);
        List<Integer> list1 = list.stream().map(s -> Integer.parseInt(s)).filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(list1);

    }
}
