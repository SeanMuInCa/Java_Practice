package MyLinkedList;

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

        public Node(Node<E> next, E data)
        {
            this.next = next;
            this.data = data;
        }
    }

    public void add(E e)
    {
        Node<E> newNode = new Node<>(null, e);
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
    }

    public void delete(E e)
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
    }

    public void update(E oldValue, E value)
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
    }

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
        }
    }
}
