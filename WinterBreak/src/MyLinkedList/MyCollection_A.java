package MyLinkedList;

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
 * NVMQQ-FF6TP-WV989-74RHJ-4VYM8
 */
public abstract class MyCollection_A<T> extends MyCollection<T> implements Comparable<T>
{
    public abstract void Add(T data);

    public abstract void Clear();

    public abstract boolean Remove(T data);

    public abstract Iterator<T> getIterator();


    public boolean Contains(T data)
    {
        boolean found = false;

        Iterator<T> list = getIterator();

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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        String sep = ", ";
        for (T data : this)
        {
            sb.append(data + sep);
        }
        if (this.getCount() > 0)
        {
            sb.delete(sb.length() - sep.length(), sb.length() - 1);
        }
        sb.append(']');
        return sb.toString();
    }
}
