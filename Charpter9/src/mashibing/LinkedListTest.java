package mashibing;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Purpose:             mashibing<br />
 * Data Submitted:      2023/11/20 <br />
 * Assignment Number:    mashibing<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("abc");
        ll.add("abstract");
        ll.add("a");

/*        ll.pollFirst();
        ll.removeFirst();//这俩一样，poll是新的，所以用这个，空的时候不会报错*/
        for (int i = 0; i < ll.size(); i++)
        {
            System.out.println(ll.get(i));
        }
        System.out.println("-------------------------");
        for (Object o : ll){
            System.out.println(o);
        }
        System.out.println("-------------------------");
        Iterator<String> it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
