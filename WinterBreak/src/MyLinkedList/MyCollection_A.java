package MyLinkedList;

import java.util.Enumeration;
import java.util.Iterator;

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
public abstract class MyCollection_A<T> extends MyCollection<T>
{

    public abstract void Add(T data);

    public abstract void Clear();

    public abstract boolean Remove(T data);

    public abstract Enumeration<T> GetEnumerator();


    public virtual
    int Count

    {
        get
        {
            int count = 0;
            foreach(T data in this)
            {
                count++;
            }
            return count;
        }
    }

    public boolean Contains(T data)
    {
        boolean found = false;

        Iterator<T> list = GetEnumerator().asIterator();

        while (list.hasNext())
        {
            if (data.equals(list.next()))
            {
                found = true;
                break;
            }
        }
        return found;
    }

    public String ToString()
    {
        StringBuilder sb = new StringBuilder("[");
        String sep = ", ";
        foreach(T data in this)
        {
            sb.Append(data + sep);
        }
        if (this.Count > 0)
        {
            sb.Remove(sb.Length - sep.Length, sep.Length);
        }
        sb.Append(']');
        return sb.ToString();
    }

    IEnumerator IEnumerable.

    GetEnumerator()
    {
        return GetEnumerator();
    }
}
