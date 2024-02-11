package TestCollection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class ImmutableDemo1
{
    //不可变的集合list，set,map都有of方法
    //map.of只能10对数据
    //map.ofEntries可以不限制
    public static void main(String[] args)
    {
        //Map<Integer,String> map = new HashMap<>();
        //不可修改
        List<String> family = List.of("raina", "rainba", "rainma");
        /*for (int i = 0; i < family.size(); i++)
        {
            map.put(i, family.get(i));
        }*/
        Map<Integer,String> map = family.stream().collect(Collectors.toMap(family::indexOf, str -> str));

        //family.add("zzs");
        //Map<Integer, String> map = Map.of(1, "zs", 2, "ls");
        map.forEach((k,v) ->
        {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
