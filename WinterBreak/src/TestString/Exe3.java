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
 * 查找某个字符串出现的次数
 */
public class Exe3
{
    static int counter = 0;
    public static void main(String[] args)
    {
        String str = "abkkkabsdafasdabdsafab";
        String subStr = "ab";
        System.out.println(getCount3(str, subStr));
    }

    private static int getCount(String str, String subStr)
    {
        int counter = 0;
        if (str == null || subStr == null)
        {
            return 0;
        }
        char start = subStr.charAt(0);
        int length = subStr.length();
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == start){
                if(str.substring(i, i + length).equals(subStr)){
                    counter++;
                }
            }
        }
        return counter;
    }
    public static int getCount2(String str, String subStr)
    {

        if (str == null || subStr == null)
        {
            return 0;
        }
        if(str.contains(subStr)){
            counter++;
            getCount2(str.substring(str.indexOf(subStr) + subStr.length()), subStr);
        }
            return counter;

    }
    public static int getCount3(String str, String subStr){
        if (str == null || subStr == null)
        {
            return 0;
        }
        int count = 0;
        int index = str.indexOf(subStr);
        while (index >= 0){
            count++;
            index = str.indexOf(subStr, index + subStr.length());
        }
        return count;
    }
}
