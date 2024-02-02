package Algrithm.LinkedList;

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
public class LinkedList
{
    //虚拟头节点
    public ListNode delete1(ListNode head, int val)
    {
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head.next != null)
        {
            if (head.next.val == val)
            {
                head.next = head.next.next;
            }
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
            while (cur.next != null && cur.next.val == val)
            {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }
}
