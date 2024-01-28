package BinarySearchTree;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/28 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Heap<E>
{
    private ArrayList<E> list = new ArrayList<>();
    private Comparator<? super E> c;
    public Heap(){
        this.c = (e1,e2) -> ((Comparable<E>)e1).compareTo(e2);
    }
    public Heap(E[] objects)
    {
        this.c = (e1,e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
        {
            add(objects[i]);
        }
    }
    public void add(E newObject)
    {

    }
}
