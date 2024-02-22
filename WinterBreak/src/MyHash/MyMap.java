package MyHash;

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
public interface MyMap<K,V>
{
    public void clear();
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public Set<Entry<K,V>> entrySet();
    public V get(K key);
    public boolean isEmpty();
    public Set<K> keySet();
    public V put(K key, V value);
    public void remove(K key);
    public int size();
    public Set<V> values();

}
