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
public interface MyList<T> extends MyCollection<T>, Comparable<T>
{
    T ElementAt(int index);
}
