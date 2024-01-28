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

    public Heap()
    {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    public Heap(E[] objects)
    {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
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
            if (c.compare(list.get(curIndex), list.get(parentIndex)) > 0)
            {
                E temp = list.get(curIndex);
                list.set(curIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else break;

            curIndex = parentIndex;
        }
    }

    public E remove()
    {
        if (list.isEmpty()) return null;
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size())
        {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size())
            {
                if (c.compare(list.get(maxIndex),
                        list.get(rightChildIndex)) < 0)
                {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (c.compare(list.get(currentIndex),
                    list.get(maxIndex)) < 0)
            {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }
    public int getSize(){ return list.size();}
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString()
    {
        return "Heap{" +
                "list=" + list +
                '}';
    }
}
