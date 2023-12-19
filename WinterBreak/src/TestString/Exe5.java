package TestString;

/**
 * Purpose:             TestString<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    TestString<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestString <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe5
{
    public static void main(String[] args)
    {
        String str = "bcda";
        System.out.println(getOrder(str));
    }

    public static String getOrder(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i; j < arr.length; j++)
            {
                if(arr[i] > arr[j]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return String.valueOf(arr);
    }
}
