package Algrithm.StackAndQueue;

/**
 * Purpose:             Algrithm.StackAndQueue<br />
 * Data Submitted:      2024/2/7 <br />
 * Assignment Number:    Algrithm.StackAndQueue<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.StackAndQueue <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestQueue
{
    public static void main(String[] args)
    {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
