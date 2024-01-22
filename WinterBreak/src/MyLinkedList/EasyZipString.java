package MyLinkedList;

import java.util.LinkedList;

/**
 * Purpose:             MyLinkedList<br />
 * Data Submitted:      2024/1/21 <br />
 * Assignment Number:    MyLinkedList<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyLinkedList <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class EasyZipString
{
    public static void main(String[] args)
    {
        String str = "AAAABCCDEEEEEF";
        System.out.println(zipString(str));

    }
    /**
     * 实现简易字符串压缩算法，其中连续出现2次以上（含2次）的字母转换为字母和出现的次数。
     * 例如：AAAABCCDEEEEE,压缩之后为A4BC2DE5。
     * @param str 输入字符串
     */
    public static String zipString(String str){
        String res = "";
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if(list.isEmpty())
            {
                list.addLast(str.charAt(i) + "");
                count++;
            }else
            {
                if(list.getLast().equals(str.charAt(i) + ""))
                {
                    count++;
                }else
                {
                    if(count > 1)
                    {
                        list.addLast(count + "");
                    }
                    list.addLast(str.charAt(i) + "");
                    count = 1;
                }
            }
        }
        if(count > 1)
        {
            list.addLast(count + "");
        }
        while (!list.isEmpty())
        {
            res += list.pollFirst();
        }
        return res;
    }
}
