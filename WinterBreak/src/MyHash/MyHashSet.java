package MyHash;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

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
public class MyHashSet<E> implements Collection<E>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    private float loadFactorThreshold;
    private int size = 0;
    LinkedList<E>[] table;

    public MyHashSet()
    {
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int capacity)
    {
        this(capacity,DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity, float loadFactorThreshold)
    {
        if(initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    private int trimToPowerOf2(int initialCapacity)
    {
        int capacity = 1;
        while (capacity < initialCapacity)
        {
            capacity *= 2;
        }
        return capacity;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean contains(Object e)
    {
        int index = hash(e.hashCode());
        if(table[index] != null)
        {
            LinkedList<E> bucket = table[index];
            return bucket.contains(e);
        }
        return false;
    }

    private int hash(int hashCode)
    {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    private static int supplementalHash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public Iterator<E> iterator()
    {
        return new MyHashSetIterator(this);
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean add(E e)
    {
        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public void clear()
    {
        size = 0;
        removeElements();
    }
}
