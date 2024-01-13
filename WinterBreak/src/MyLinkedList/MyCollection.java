package MyLinkedList;

/**
 * Purpose:             MyLinkedList<br />
 * Data Submitted:      2024/1/12 <br />
 * Assignment Number:    MyLinkedList<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyLinkedList <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public abstract class MyCollection<T> implements Iterable<T>, Comparable<T>
{
    //add the given data to the collection
    abstract void Add(T data);

    //remove all datas from the collection
    abstract void Clear();

    //determin the given data is in the collection or not
    abstract boolean Contains(T data);

    //compare with other one to see if they are equals
    abstract boolean Equals(Object other);

    //remove a specific data occurence the first from the collection
    abstract boolean Remove(T data);

    //call to get a property
    private int count;

    public int getCount()
    {
        return count;
    }
}
