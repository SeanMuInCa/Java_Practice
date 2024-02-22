package MyHash;

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
public class Entry<K,V>
{
     K key;
     V value;
    public Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "{" +  key +", " + value +'}';
    }
}
