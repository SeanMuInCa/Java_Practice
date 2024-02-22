package MyHash;

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
public class MyHashMap<K, V> implements MyMap<K,V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    private float loadFactorThreshold;
    private int size = 0;
    LinkedList<Entry<K, V>>[] table;

    public MyHashMap()
    {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int capacity)
    {
        this(capacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactorThreshold)
    {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPowerOf2(initialCapacity);

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
    public void clear()
    {
        size = 0;
        removeEntries();
    }

    private void removeEntries()
    {
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                table[i].clear();
            }
        }
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
            if (table[i] != null)
            {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket)
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
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket)
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
        int index = hash(key.hashCode());
        if (table[index] != null)
        {
            LinkedList<Entry<K, V>> bucket = table[index];
            for (Entry<K, V> entry : bucket)
            {
                if (entry.getKey().equals(key))
                    return entry.getValue();
            }
        }
        return null;
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
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public Set<K> keySet()
    {
        Set<K> set = new HashSet<>();

        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket)
                    set.add(entry.getKey());
            }
        }

        return set;
    }

    @Override
    public V put(K key, V value)
    {
        if (get(key) != null)
        { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket)
                if (entry.getKey().equals(key))
                {
                    V oldValue = entry.getValue();
                    // Replace old value with new value
                    entry.value = value;
                    // Return the old value for the key
                    return oldValue;
                }
        }

        // Check load factor
        if (size >= capacity * loadFactorThreshold)
        {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        // Create a linked list for the bucket if not already created
        if (table[bucketIndex] == null)
        {
            table[bucketIndex] = new LinkedList<Entry<K, V>>();
        }

        // Add a new entry (key, value) to hashTable[index]
        table[bucketIndex].add(new Entry<K, V>(key, value));

        size++; // Increase size

        return value;
    }

    private void rehash()
    {
        Set<Entry<K, V>> set = entrySet(); // Get entries
        capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        table = new LinkedList[capacity]; // Create a new hash table
        size = 0; // Reset size to 0
        for (Entry<K, V> entry : set)
        {
            put(entry.getKey(), entry.getValue()); // Store to new table
        }
    }

    @Override
    public void remove(K key)
    {
        int bucketIndex = hash(key.hashCode());

        // Remove the first entry that matches the key from a bucket
        if (table[bucketIndex] != null)
        {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket)
            {
                if (entry.getKey().equals(key))
                {
                    bucket.remove(entry);
                    size--; // Decrease sizebreak; // Remove just one entry that matches the key
                }
            }
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Set<V> values()
    {
        Set<V> set = new java.util.HashSet<>();
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket)
                    set.add(entry.getValue());
            }
        }
        return set;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null && table[i].size() > 0)
                for (Entry<K, V> entry : table[i])
                    builder.append(entry);
        }
        builder.append("]");
        return builder.toString();
    }
}
