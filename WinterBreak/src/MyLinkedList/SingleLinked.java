package MyLinkedList;

import java.util.Iterator;

/**
 * Purpose:             MyLinkedList<br />
 * Data Submitted:      2024/1/18 <br />
 * Assignment Number:    MyLinkedList<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          MyLinkedList <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class SingleLinked implements Iterable
{
    private Node first;
    /*public void add(Object element)
    {
        Node newNode = new Node(element, null);
        if(first == null){
            first = newNode;
            return;
        }

        Node node = first;
        while(node.next != null){
            node = node.next;
        }
        node.next = newNode;

    }*/
    public void add(Object element){
        Node newNode = new Node(element, null);
        if(first == null){
            first = newNode;
        }else recAdd(first,element);
    }

    private void recAdd(Node cur, Object data)
    {
        if(cur.next == null)
            cur.next = new Node(data,null);
        else recAdd(cur.next, data);
    }

    @Override
    public Itr iterator()
    {
        return new Itr();
    }

    private static class Node
    {
        Object data;
        Node next;

        public Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    private class Itr implements Iterator
    {
        Node node = first;

        @Override
        public boolean hasNext()
        {
            return node != null;
        }

        @Override
        public Object next()
        {
            Object data = node.data;
            node = node.next;
            return data;
        }
    }
    public static void main(String[] args) {
        //高内聚低耦合
        SingleLinked link = new SingleLinked();
        link.add("张三");
        link.add("李四");
        link.add("王五");
        link.add("赵六");

        for (Object o : link) {
            System.out.println(o);
        }
    }
}
