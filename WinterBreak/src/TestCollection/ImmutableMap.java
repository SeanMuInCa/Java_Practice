package TestCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2024/2/11 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ImmutableMap
{
    public static void main(String[] args)
    {
        //1先创建一个普通map
        //2.由于这个超过10对了，所以不能用map.of，只能用map.ofEntries
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(4,"a");
        map.put(5,"a");
        map.put(6,"a");
        map.put(7,"a");
        map.put(8,"a");
        map.put(9,"a");
        map.put(10,"a");
        map.put(11,"a");
        map.put(12,"a");
        map.put(13,"a");
        map.put(14,"a");
        map.put(15,"a");
        map.put(16,"a");
        map.put(17,"a");
        map.put(18,"a");
        map.put(19,"a");
        map.put(20,"a");

        //获取entry
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        //转成数组
        Map.Entry<Integer,String>[] array = entries.toArray(new Map.Entry[0]);//会自动根据数据量变长，因此写几都可以
        Map<Integer, String> newmap = Map.ofEntries(array);//可变参数底层就是数组
        newmap.forEach((k,v) -> System.out.println(k));
        //newmap.put(33,"aaa"); immutable

        //只需一句话即可 java10以后

        Map<Integer, String> immtableMap = Map.copyOf(map);
        //immtableMap.put(33,"aaa");
    }
}
