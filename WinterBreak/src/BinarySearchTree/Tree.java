package BinarySearchTree;

import java.util.Collection;
import java.util.Iterator;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/24 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public interface Tree<E> extends Collection<E>
{
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete(E e);
    public int getSize();
    public default void inorder(){}
    public default void postorder(){}
    public default void preorder(){}
    @Override
    public default boolean isEmpty(){
        return size() == 0;
    }
    @Override
    public default boolean contains(Object o)
    {
        return search((E) o);
    }
    @Override
    public default boolean add(E e)
    {
        return insert(e);
    }
    @Override
    public default boolean remove(Object o)
    {
        return delete((E)o);
    }
    @Override
    public default int size()
    {
        return getSize();
    }
    public default boolean containsAll(Collection<?> c)
    {
        //todo
        return false;
    }
    @Override
    public default boolean addAll(Collection<? extends E> c)
    {
        boolean flag = true;
        for (int i = 0; i < c.size(); i++)
        {
            if(add((E) c.toArray()[i])) flag = false;
        }
        return flag;
    }
    @Override
    public default boolean removeAll(Collection<?> c)
    {
        boolean flag = true;
        for (int i = 0; i < c.size(); i++)
        {
            if(remove((E) c.toArray()[i])) flag = false;
        }
        return flag;
    }
    @Override
    public default boolean retainAll(Collection<?> c)
    {
        //todo
        return false;
    }
    @Override
    public default Object[] toArray()
    {
        int index = 0;
        Object[] arr = new Object[size()];
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext() && index < size())
        {
            arr[index++] = iterator.next();
        }
        return arr;
    }
    @Override
    public default <T> T[] toArray(T[] array)
    {
        //todo
        return null;
    }
}
