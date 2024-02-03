package Algrithm.LinkedList;

import java.util.Iterator;

/**
 * Purpose:             Algrithm.LinkedList<br />
 * Data Submitted:      2024/2/2 <br />
 * Assignment Number:    Algrithm.LinkedList<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.LinkedList <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LinkedList implements Iterable
{
    private ListNode head;
    int size = 0;
    //虚拟头节点
    public ListNode delete1(ListNode head, int val)
    {
        if (head == null)  return null;

        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        /*ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }*/
        ListNode cur = dummy;
        while (cur.next != null)
        {
            if(cur.next.val == val)
            {
                cur.next = cur.next.next;
                size--;
            }
            else cur = cur.next;
        }
        return dummy.next;
    }

    //遍历法
    public ListNode delete2(ListNode head, int val)
    {
        while (head != null && head.val == val)
        {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null)
        {
            while (cur.next != null && cur.next.val == val)//这里没有用if的原因，是因为中间可能有重复元素
            {
                cur.next = cur.next.next;
                size--;
            }
            cur = cur.next;
        }

        return head;
    }

    public void addTop(int val)
    {
        if(head == null)
        {
            head = new ListNode(val);
        }
        else
        {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void add(int val)
    {
        if(head == null)
        {
            head = new ListNode(val);
        }
        else
        {
            ListNode cur = head;
            ListNode newNode = new ListNode(val);
            while (cur.next != null)
            {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }
    public ListNode get(int index)
    {
        if(index < 0 || index > this.getSize() - 1)
        {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++)
        {
            cur = cur.next;
        }
        return cur;
    }
    public void insert(int val, int index)
    {
        if(index == 0)
        {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++)
        {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    public void delete(int index)
    {
        if(index == 0)
        {
            head = head.next;
        } else
        {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++)
            {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }
    public int getSize(){ return size;}
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.add( 1);
        list.add( 2);
        list.add( 3);

        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
        list.insert(5,0);
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
        list.delete(1);
        for (Object o : list) {
            System.out.print(o + " ");
        }

    }

    @Override
    public Iterator iterator()
    {

        return new Iterator()
        {
            ListNode node = head;
            @Override
            public boolean hasNext()
            {
                return node != null;
            }

            @Override
            public Object next()
            {
                Object data = node.val;
                node = node.next;
                return data;
            }
        };
    }
}
