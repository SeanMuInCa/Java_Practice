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
        if (head == null) return null;

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
            if (cur.next.val == val)
            {
                cur.next = cur.next.next;
                size--;
            } else cur = cur.next;
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
        if (head == null)
        {
            head = new ListNode(val);
        } else
        {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(int val)
    {
        if (head == null)
        {
            head = new ListNode(val);
        } else
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
        if (index < 0 || index > this.getSize() - 1)
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
        if (index == 0)
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
        if (index == 0)
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

    public void deleteFromLast(int num)
    {
        if (num > size) return;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int steps = num + 1;
        while (steps-- > 0)
        {
            fast = fast.next;
        }
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        size--;
    }

    public void reverse()
    {
//        head = twoPointerReverse();
        head = recReverse(head, null);
    }

    private ListNode recReverse(ListNode cur, ListNode pre)
    {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return recReverse(temp, cur);
    }

    private ListNode twoPointerReverse()
    {
        if (this.size <= 0) return null;
        if (this.size == 1) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null)
        {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public void swapNeighbourNodes()
    {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; // 将虚拟头结点指向head，这样方便后面做删除操作
        ListNode cur = dumyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null)
        {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur = firstnode; // cur移动，准备下一轮交换
        }
        head = dumyhead.next;
    }

    public void swap()
    {
        head = recSwap(head);
    }

    private ListNode recSwap(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;

        ListNode newNode = recSwap(next.next);

        next.next = head;
        head.next = newNode;
        return next;
    }

    //determine the linkedlist has a circle or  not
    public boolean isThereCircle(ListNode fast, ListNode slow)
    {
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public ListNode findCircleEntrance()
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public int getSize()
    {
        return size;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(7);

        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        list.insert(5, 0);
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        list.delete(1);
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        list.reverse();
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        list.swapNeighbourNodes();
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        list.swap();
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        System.out.println();
        System.out.println(list.getSize());
        System.out.println();
        list.deleteFromLast(1);
        for (Object o : list)
        {
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
