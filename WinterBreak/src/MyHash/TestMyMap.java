package MyHash;

/**
 * Purpose:             MyMap<br />
 * Data Submitted:      2024/2/21 <br />
 * Assignment Number:    MyMap<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestMyMap
{
    public static void main(String[] args)
    {
        MyMap<String,Integer> map = new MyHashMap<String, Integer>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);

        System.out.println("Entries in map: " + map);

        System.out.println("The age for Lewis is " + map.get("Lewis"));

        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        System.out.println("Is age 33 in the map? " + map.containsValue(33));

        map.remove("Smith");
        System.out.println("Entries in map: " + map);

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
