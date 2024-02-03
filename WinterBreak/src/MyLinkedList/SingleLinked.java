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
    private Node head;
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
        Node newNode = new Node(element);
        if(head == null){
            head = newNode;
        }else recAdd(head,element);
    }

    private void recAdd(Node cur, Object data)
    {
        if(cur.next == null)
            cur.next = new Node(data);
        else recAdd(cur.next, data);
    }

    public void delete(String val)
    {
        head = delete1(head,val);
    }
    public Node delete1(Node head, String val)
    {
        if (head == null)  return null;

        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        Node dummy = new Node(-1, head);
        /*Node pre = dummy;
        Node cur = head;
        while (cur != null) {
            if (cur.data == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }*/
        Node cur = dummy;
        while (cur.next != null)
        {
            if(cur.next.data.equals(val))
            {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
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

        public Node(Object data)
        {
            this(data,null);
        }

        public Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    private class Itr implements Iterator
    {
        Node node = head;

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
        SingleLinked link = new SingleLinked();
        link.add("张三");
        link.add("李四");
        link.add("王五");
        link.add("赵六");
        link.delete("张三");
        for (Object o : link) {
            System.out.println(o);
        }
    }
}
