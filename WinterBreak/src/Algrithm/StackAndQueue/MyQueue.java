package Algrithm.StackAndQueue;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
        * Your MyQueue object will be instantiated and called as such:
        * MyQueue obj = new MyQueue();
        * obj.push(x);
        * int param_2 = obj.pop();
        * int param_3 = obj.peek();
        * boolean param_4 = obj.empty();
        */
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(out.empty())
        {
            while (!in.empty())
            {
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    public int peek() {
        if(out.empty())
        {
            while (!in.empty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
