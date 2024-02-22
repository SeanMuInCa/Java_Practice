package MyMap;

import java.util.HashSet;
import java.util.LinkedList;

import java.util.Set;

/**
 * Purpose:             MyMap<br />
 * Data Submitted:      2024/2/21 <br />
 * Assignment Number:    MyMap<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class MyHashMap<K,V> implements MyMap<K,V>
{
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    private float loadFactorThreshold;
    private int size = 0;
    LinkedList<Entry<K,V>>[] table;
    public MyHashMap()
    {
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int capacity)
    {
        this(capacity,DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int initialCapacity, float loadFactorThreshold)
    {
        if(initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table  = new LinkedList[capacity];
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
    public void clear()
    {
        size = 0;
        removeEntries();
    }

    private void removeEntries()
    {
    }

    @Override
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value)
    {
        for (int i = 0; i < capacity; i++)
        {
            if(table[i] != null)
            {
                LinkedList<Entry<K,V>> bucket = table[i];
                for (Entry<K,V> entry : bucket)
                {
                    if (entry.getValue().equals(value))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        Set<Entry<K,V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++)
        {
            if(table[i] != null)
            {
                LinkedList<Entry<K,V>> bucket = table[i];
                for (Entry<K,V> entry : bucket)
                {
                    set.add(entry);
                }
            }
        }
        return set;
    }

    @Override
    public V get(K key)
    {
        return null;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public Set<K> keySet()
    {
        return null;
    }

    @Override
    public V put(K key, V value)
    {
        return null;
    }

    @Override
    public void remove(K key)
    {

    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Set<V> values()
    {
        return null;
    }
}
