package CollectionsToolClass;


import org.junit.Test;

import java.util.*;

/**
 * Purpose:             CollectionsToolClass<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    CollectionsToolClass<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          CollectionsToolClass <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * Collections是一个操作set,map,list的工具类
 */
public class TestCollections
{
    /*
    * reverse(list)
    * shuffle(list)
    * sort(list)
    * sort(list, comparator)
    * swap(list,int,int)
    * */
    @Test
    public void test(){
        List list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(list);
        Collections.swap(list,0,1);
        System.out.println(list);
    }

    /*
    * max(list)
    * max(list, comparator)
    * min(list)
    * min(list, comparator)
    * binarySearch(list, key)
    * binarySearch(list, key, comparator)
    * frequency(list, key)
    * */
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        list.add("cc");
        list.add("dd");
        System.out.println(list);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        String max = Collections.max(list, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(max);

        System.out.println(Collections.frequency(list, "cc"));

        System.out.println(Collections.binarySearch(list, "cc"));
    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        list.add("cc");
        list.add("dd");

//        List<String> list1 = new ArrayList<>();这样list1的size是0，所以不行
        List<String> list1 = Arrays.asList(new String[list.size()]);//初始化一个长度一样的list
        //copy方法
        Collections.copy(list1,list);
        System.out.println(list1.size());
    }
    @Test
    public void test3(){
        //unmodifiableList(list)返回一个只读属性的list
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        list.add("cc");
        list.add("dd");
        List<String> list1 = Collections.unmodifiableList(list);
//        list1.remove(0);
        //synchronizedList(list)返回一个同步的线程安全的list
        List<String> list2 = Collections.synchronizedList(list);
    }
}
