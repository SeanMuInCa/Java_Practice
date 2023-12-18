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
public class Exe4
{
    public static void main(String[] args)
    {
        String str1 = "asdfhelloasdf";
        String str2 = "asdfasddfhelloasdafsdf";
        System.out.println(getMaxSameSubString(str1,str2));
    }
    public static String getMaxSameSubString(String str1, String str2){
        if(str1 != null && str2!= null){
            String maxStr = str1.length() > str2.length()? str1 : str2;
            String minStr = str1.length() < str2.length()? str1 : str2;

            int length = minStr.length();

            for (int i = 0; i < length; i++)
            {
                for (int j = 0, k = length - i; k <= length ; j++, k++)
                {
                    if(maxStr.contains(minStr.substring(j,k))){
                        return minStr.substring(j,k);
                    }
                }
            }
        }
        return null;
    }
}
