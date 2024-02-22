package MyHash;

import java.util.Collection;

/**
 * Purpose:             MyHash<br />
 * Data Submitted:      2024/2/22 <br />
 * Assignment Number:    MyHash<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyHash <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestMyHashSet
{
    public static void main(String[] args)
    {
        // Create a MyHashSet
        Collection<String> set = new MyHashSet<>();
        set.add("Smith");
        set.add("Anderson");
        set.add("Lewis");
        set.add("Cook");
        set.add("Smith");

        System.out.println("Elements in set: " + set);
        System.out.println("Number of elements in set: " + set.size());
        System.out.println("Is Smith in set? " + set.contains("Smith"));

        set.remove("Smith");
        System.out.print("Names in set in uppercase are ");
        for (String s : set) System.out.print(s.toUpperCase() + " ");

        set.clear();
        System.out.println("\nElements in set: " + set);
    }
}
