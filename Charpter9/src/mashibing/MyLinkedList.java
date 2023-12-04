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
public class MyLinkedList
{
    //链表中，一定有首尾两个节点
    Node firstNode = null;
    Node lastNode = null;
    int count = 0;

    public MyLinkedList()
    {
    }



    public void add(Object obj) {

        if(firstNode == null)
        {
            Node node = new Node();
            node.setPre(null);
            node.setObj(obj);
            node.setNext(null);
            firstNode = node;
            lastNode = node;
        }else{
            Node node = new Node();
            node.setObj(obj);
            node.setPre(lastNode);
            node.setNext(null);
            lastNode.setNext(node);
            lastNode = node;
        }
        count++;
    }
    public int getSize(){
        return count;
    }
    public Object getNode(int index) {
        Node node = firstNode;
        for (int i = 0; i < index; i++)
        {
            node = node.getNext();
        }
        return node.getObj();
    }
}
class Test{
    public static void main(String[] args)
    {
        MyLinkedList l = new MyLinkedList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        System.out.println(l.getSize());
        System.out.println(l.getNode(2));}
}