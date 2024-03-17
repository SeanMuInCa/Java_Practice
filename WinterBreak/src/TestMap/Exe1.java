package TestMap;

import java.util.*;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe1
{
    public static void main(String[] args)
    {
        String singer = "abc";
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        Map<String, List<String>> map = new HashMap<>();
        map.put(singer, list);

        String singer1 = "def";
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("xxx");
        list1.add("yyy");
        list1.add("zzz");


        map.put(singer1, list1);

        Set<Map.Entry<String, List<String>>> set = map.entrySet();
        for (Map.Entry<String,List<String>> entry : set)
        {
            for (String str : entry.getValue())
            {
                System.out.println(entry.getKey() + " ---- " + str);
            }
        }
        /*Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " --- " + entry.getValue());
//            System.out.println(iterator.next());
        }*/
    }
}
