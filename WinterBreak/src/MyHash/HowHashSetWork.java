package MyHash;

import java.util.HashSet;

/**
 * Purpose:             MyHash<br />
 * Data Submitted:      2024/3/16 <br />
 * Assignment Number:    MyHash<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          MyHash <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class HowHashSetWork
{
    public static void main(String[] args)
    {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("通话");//hashcode一样1179395
        set.add("重地");//hashcode一样1179395
        set.add("abc");

        System.out.println("通话".hashCode());
        System.out.println("重地".hashCode());
        //为什么内容一样不能加入，但是Hash一样却可以？这明明是hashset
        //需要注意，String是重写了hash和equals方法的类
        /*1.先计算hash（重写hash）
          2.如果hash不一样，直接存
          3. 如果hash一样，再比较内容（equals）
          4. 内容如果不一样，那么存
          5. 如果不一样，就去重*/

    }
}
