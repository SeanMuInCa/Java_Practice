package Stack;

import java.util.ArrayList;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/13 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Stack <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class MyStack
{
    private ArrayList list = new ArrayList();
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int getSize() {
        return list.size();
    }
    public Object peek(){
        return list.get(list.size() - 1);
    }
    public Object pop(){
        Object obj = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return obj;
    }
    public void push(Object obj){
        list.add(obj);
    }

    @Override
    public String toString()
    {
        return "MyStack{" +
                "list=" + list +
                '}';
    }
}
