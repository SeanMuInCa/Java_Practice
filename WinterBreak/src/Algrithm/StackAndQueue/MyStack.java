package Algrithm.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

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
class MyStack {

    Deque<Integer> q = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        q.push(x);
    }

    public int pop() {
        int n = q.size();
        for (int i = 0; i < n - 1; i++)
        {
            int ele = q.pop();
            q.push(ele);
        }
        return q.pop();
    }

    public int top() {
        int x = this.pop();
        this.push(x);
        return x;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
