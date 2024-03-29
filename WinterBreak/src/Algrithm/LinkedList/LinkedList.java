package Algrithm.LinkedList;

import java.util.Iterator;
import java.util.Stack;

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
public class LinkedList<E> implements Iterable
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

    public ListNode reverse(ListNode head)
    {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //这个节点就是目标反转节点的下一个节点
    ListNode targetNext = null;

    public ListNode reverseN(ListNode head, int n)
    {
        if (n == 1)
        {
            //如果反转的就是头
            targetNext = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        //链表反转最后的结果，都是头和下一个互相指，因此需要反转一下
        head.next.next = head;
        head.next = targetNext;
        return last;
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
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2)
                {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    /**
     * delete all targets
     *
     * @param target
     */
    public void deleteTarget(int target)
    {
        if (head.val == target)
        {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null)
        {
            if (cur.next.val == target)
            {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    public static boolean isPalindrome(LinkedList list)
    {
        if (list == null || list.size == 0)
        {
            return false; // 空链表不是回文链表
        }
        Stack stack = new Stack();
        int index = list.size / 2;
        int rest = list.size % 2;
        for (int i = 0; i < index; i++)
        {
            if (list.get(i) != null)
            {
                stack.push(list.get(i).val);
            }
        }
        int pivot = (rest == 1) ? index + 1 : index;
        System.out.println(pivot);
        while (!stack.isEmpty())
        {
            if (!(stack.peek().equals(list.get(pivot).val)))
            {
                return false;
            }
            stack.pop();
            pivot++;
        }
        return true;
    }

    public int getSize()
    {
        return size;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        //list.add(3);
        list.add(2);
        list.add(1);

        //list.deleteTarget(1);
        System.out.println(isPalindrome(list));
        for (Object o : list)
        {
            System.out.print(o + " ");
        }
        /*System.out.println();
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
        }*/
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
