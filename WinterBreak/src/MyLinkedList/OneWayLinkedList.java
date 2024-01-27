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
public class OneWayLinkedList<E>
{
    private Node<E> head;
    private int total;

    private static class Node<E>
    {
        Node<E> next;
        E data;

        public Node(E data){
            this(data,null);
        }
        public Node(E data, Node<E> next)
        {
            this.next = next;
            this.data = data;
        }
    }


    /*public void add(E e)
    {
        Node<E> newNode = new Node<>(e);
        if (head == null)
        {
            head = newNode;
        } else
        {
            Node<E> node = head;
            while (node.next != null)
            {
                node = node.next;
            }
            node.next = newNode;
        }
        total++;
    }*/

    /**
     * 获取第几个元素
     * @param index
     * @return
     */
    public Node<E> get(int index)
    {
        if(index < 0 || index > total - 1)
        {
            return null;
        }
        Node<E> cur = head;
        while (index > 0)
        {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * 头部加入节点
     */
    public void addToHead(E e)
    {
        if(head == null)
        {
            head = new Node<>(e);
        }else
        {
            Node<E> newNode = new Node<>(e);
            /*Node<E> temp = head;
            head = newNode;
            head.next = temp;*/
            newNode.next = head;
            head = newNode;
            total++;
        }
    }
    /**
     * 尾部插入节点
     * @param e
     */
    public void add(E e)
    {
        total++;
        if(head == null)
            head = new Node<>(e);
        else recAdd(head, e);
    }

    private void recAdd(Node<E> cur, E e)
    {
        if(cur.next == null)
            cur.next = new Node<>(e);
        else recAdd(cur.next, e);
    }

    public void delete(E e)
    {
        if(head.data.equals(e))
        {
            head = head.next;
            total--;
        }else {
            recDelete(head, e);
        }
    }

    private void recDelete(Node<E> cur, E e)
    {
        if(cur != null && cur.next != null)
        {
            if(cur.next.data.equals(e))
            {
                cur.next = cur.next.next;
                total--;
            }else
                recDelete(cur.next, e);
        }
    }
    /*public void delete(E e)
    {
        Node<E> node = head;
        Node<E> find = null;
        Node<E> last = null;

        if (e == null)
        {
            while (node != null)
            {
                find = node;
                break;
            }
            last = node;
            node = node.next;
        } else
        {
            while (node != null)
            {
                if (e.equals(node.data))
                {
                    find = node;
                    node = node.next;
                }
            }
        }
        if (find != null)
        {
            if (last == null)
            {
                head = find.next;
            } else
            {
                last.next = find.next;
            }
            total--;
        }
    }*/

    public void update(E oldValue, E value)
    {
        if(head.data.equals(oldValue))
        {
            head.data = value;
        } else
        {
            recUpdate(head, oldValue,value);
        }
    }

    private void recUpdate(Node<E> cur, E oldValue, E value)
    {
        if(cur != null && cur.next != null)
        {
            if(cur.next.data.equals(oldValue))
            {
                cur.next.data = value;
            }else {
                recUpdate(cur.next,oldValue,value);
            }
        }
    }
    public E replaceAt(int index, E data)
    {
        Node<E> replaced = recReplace(index,head,data);
        return replaced.data;
    }

    private Node<E> recReplace(int index, Node<E> cur, E data)
    {
        if (index == 0)
        {
            cur.data = data;
        }
        else recReplace(index - 1, cur.next, data);
        return cur;
    }
    /*public void update(E oldValue, E value)
    {
        Node<E> node = head;
        Node<E> find = null;
        if (oldValue == null)
        {
            while (node != null)
            {
                if (node.data == null)
                {
                    find = node;
                    break;
                }
                node = node.next;
            }
        } else
        {
            while (node != null)
            {
                if (oldValue.equals(node.data))
                {
                    find = node;
                    break;
                }
                node = node.next;
            }
        }
        if (find != null)
        {
            find.data = value;
        }
    }*/

    public boolean contains(E e)
    {
        return indexOf(e) != -1;
    }

    public int indexOf(E e)
    {
        int index = -1;
        if (e == null)
        {
            int i = 0;
            for (Node<E> node = head; node != null; node = node.next)
            {
                if (node.data == e)
                {
                    index = i;
                    break;
                }
                i++;
            }
        } else
        {
            int i = 0;
            for (Node<E> node = head; node != null; node = node.next)
            {
                if (e.equals(node.data))
                {
                    index = i;
                    break;
                }
                i++;
            }
        }
        return index;
    }
    public Object[] getAll() {
        Object[] all = new Object[total];
        Node<E> node = head;
        for (int i = 0; i < all.length; i++,node = node.next) {
            all[i] = node.data;
        }
        return all;
    }

    public int size() {
        return total;
    }
    public void recReverse(Node<E> cur, Node<E> pre){
        // Base case: end of the list
        if (cur == null) {
            head = pre;
            return;
        }

        recReverse(cur.next, cur);

        cur.next = pre;
    }
    public Node<E> reverseList(Node<E> head)
    {
        if (head == null) return null;
        if (head.next == null) return head;
        Node<E> last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    Node<E> successor = null;
    public Node<E> reverseN(Node<E> head, int n)
    {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        Node<E> last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 反转链表
     */
    public void reverse()
    {
        if(head != null)
        {
            Node<E>[] all = new Node[total];
            Node<E> node = head;
            for (int i = 0; i < all.length; i++)
            {
                all[i] = node;
                node = node.next;
            }
            head = all[all.length - 1];
            node = head;
            for (int i = all.length - 2; i >= 0 ; i--)
            {
                node.next = all[i];
                node = node.next;
            }
            node.next = null;
        }
    }

    public Itr iterator()
    {
        return new Itr();
    }
    private class Itr implements Iterator<E>
    {
        Node<E> node = head;

        @Override
        public boolean hasNext()
        {
            return node != null;
        }

        @Override
        public E next()
        {
            E data = node.data;
            node = node.next;
            return data;
        }
    }
    public static void main(String[] args) {
        OneWayLinkedList<Integer> list = new OneWayLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
        /*Object[] all = list.getAll();
        System.out.println(Arrays.toString(all));

        list.reverse();

        all = list.getAll();
        System.out.println(Arrays.toString(all));*/
//        list.delete(6);
//        list.update(6,0);
//        list.reverse();
//        System.out.println(list.head.next.data);
//        list.recReverse(list.head,null);
//        list.head = list.reverseList(list.head);
//        list.addToHead(0);
//        System.out.println(list.get(0));
        list.replaceAt(4,10);
        it = list.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
        System.out.println(list.size());
    }
}
