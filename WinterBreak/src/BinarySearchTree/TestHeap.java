package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/28 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestHeap
{
    public static void main(String[] args)
    {
        Heap<Integer> list = new Heap<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        System.out.println(list);
        System.out.println(list.getSize());
    }
}
