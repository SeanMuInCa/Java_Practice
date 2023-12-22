package TestMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

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
public class CityMap
{
    public static Map model = new HashMap();
    static {
        model.put("beijing", new String[] {"beijing"});
        model.put("shanghai", new String[] {"shanghai"});
        model.put("liaoning", new String[] {"shenyang","panjin","dandong","jinzhou"});
        model.put("jilin", new String[] {"changchun","yanbian","jilin","siping"});
    }
}
class Exe2{
    public static void main(String[] args)
    {
        Iterator it = CityMap.model.keySet().iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("input the city: ");
        String city = sc.next();
        if(CityMap.model.containsKey(city)){
            print(CityMap.model.get(city));
        }else {
            System.out.println("no city");
        }
    }

    private static void print(Object o)
    {
        if (o instanceof String[]){
            String[] s = (String[]) o;
            for (String str : s){
                System.out.print(str + " ");
            }
        }
    }
}
