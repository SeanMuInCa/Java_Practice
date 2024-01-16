package TestGenerics;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2024/1/15 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GenericMethodDemo
{
    public static void main(String[] args)
    {
        Integer[] integers = {1,2,3,4,5};
        String[] strings = {"aa","bb","cc"};

        GenericMethodDemo.<Integer>print(integers);
        System.out.println();
        GenericMethodDemo.print(strings);
    }
    public static <E> void print(E[] arr){
        for (E e : arr){
            System.out.print(e + " ");
        }
    }
}
