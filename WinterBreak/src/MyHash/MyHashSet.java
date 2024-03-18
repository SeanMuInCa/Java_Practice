package MyHash;

import java.util.ArrayList;
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
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int capacity)
    {
        this(capacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity, float loadFactorThreshold)
    {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    private int trimToPowerOf2(int initialCapacity)
    {
        //8,4,2,1规则，不论你输入多少，必须要计算成2的次幂才行，并非以用户输入为准
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
        if (table[index] != null)
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
        if (contains(e)) // Duplicate element not stored
            return false;

        if (size + 1 > capacity * loadFactorThreshold)
        {
            if (capacity == MAXIMUM_CAPACITY) throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(e.hashCode());

        // Create a linked list for the bucket if not already created
        if (table[bucketIndex] == null)
        {
            table[bucketIndex] = new LinkedList<E>();
        }

        // Add e to hashTable[index]
        table[bucketIndex].add(e);

        size++; // Increase size

        return true;
    }

    @Override
    public boolean remove(Object e)
    {
        if (!contains(e))
            return false;

        int bucketIndex = hash(e.hashCode());
        if (table[bucketIndex] != null)
        {
            LinkedList<E> bucket = table[bucketIndex];
            bucket.remove(e);
        }

        size--; // Decrease size

        return true;
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

    /**
     * Inner class for iterator
     */
    private class MyHashSetIterator implements java.util.Iterator<E>
    {
        // Store the elements in a list
        private ArrayList<E> list;
        private int current = 0; // Point to the current element in list
        private MyHashSet<E> set;

        /**
         * Create a list from the set
         */
        public MyHashSetIterator(MyHashSet<E> set)
        {
            this.set = set;
            list = setToList();
        }

        @Override
        /** Next element for traversing?*/
        public boolean hasNext()
        {
            return current < list.size();
        }


        @Override
        /** Get current element and move cursor to the next */
        public E next()
        {
            return list.get(current++);
        }

        // Remove the current element returned by the last next()
        public void remove()
        {
            // Left as an exercise
            // You need to remove the element from the set
            // You also need to remove it from the list }
        }
    }

    private void removeElements()
    {
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                table[i].clear();
            }
        }
    }

    /**
     * Rehash the set
     */
    private void rehash()
    {
        java.util.ArrayList<E> list = setToList(); // Copy to a list
        capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        table = new LinkedList[capacity]; // Create a new hash table
        size = 0;

        for (E element : list)
        {
            add(element); // Add from the old table to the new table
        }
    }

    private ArrayList<E> setToList()
    {
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                for (E e : table[i])
                {
                    list.add(e);
                }
            }
        }
        return list;
    }

    @Override
    public String toString()
    {
        ArrayList<E> list = setToList();
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < list.size() - 1; i++)
        {
            builder.append(list.get(i) + ", ");
        }

        // Add the last element in the list to the string builder
        if (list.isEmpty())
            builder.append("]");
        else
            builder.append(list.get(list.size() - 1) + "]");

        return builder.toString();
    }

}
