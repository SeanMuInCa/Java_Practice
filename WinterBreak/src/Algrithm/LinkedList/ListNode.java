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
public class ListNode
{
    int val;
    ListNode next;

    public ListNode()
    {
    }

    public ListNode(int val)
    {
        this.val = val;
    }

    public ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}
