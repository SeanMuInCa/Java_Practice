package MyLinkedList;

import java.util.ListIterator;

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
public abstract class MyList<T> extends MyCollection_A<T> implements Comparable<T>
{
    public abstract T ElementAt(int index);
    public int indexOf(Object o) {
        ListIterator<T> it = (ListIterator<T>) this.getIterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return it.previousIndex();
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return it.previousIndex();
        }
        return -1;
    }
}
