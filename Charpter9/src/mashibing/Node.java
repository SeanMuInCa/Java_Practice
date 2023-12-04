package mashibing;

/**
 * Purpose:             mashibing<br />
 * Data Submitted:      2023/11/20 <br />
 * Assignment Number:    mashibing<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Node//模拟链表
{
    private Node pre;
    private Node next;
    private Object obj;

    public Node()
    {
    }

    public Node(Object obj)
    {
        this.obj = obj;
    }

    public Node getPre()
    {
        return pre;
    }

    public void setPre(Node pre)
    {
        this.pre = pre;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public String toString()
    {
        return "Node{" +
                "pre=" + pre +
                ", next=" + next +
                ", obj=" + obj +
                '}';
    }
}
