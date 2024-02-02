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
        if (head == null)  return null;

        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
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
