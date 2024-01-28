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
        list.add(newObject);
        int curIndex = list.size() - 1;

        while (curIndex > 0)
        {
            int parentIndex = (curIndex - 1) / 2;
            if(c.compare(list.get(curIndex), list.get(parentIndex)) > 0)
            {
                E temp = list.get(parentIndex);
                list.set(curIndex, list.get(parentIndex));
                list.set(parentIndex,temp);
            }else break;

            curIndex = parentIndex;
        }
    }
    public E remove(){

    }
}
