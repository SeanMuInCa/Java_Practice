package TestGenerics;

import java.util.ArrayList;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2024/1/15 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GenericStack<E>
{
    private ArrayList<E> list = new ArrayList<>();
    public int getSize(){
        return list.size();
    }
    public E peek(){
        return list.get(getSize() - 1);
    }
    public void push(E e){
        list.add(e);
    }
    public E pop(){
        E e = peek();
        list.remove(getSize() - 1);
        return e;
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString()
    {
        return "GenericStack{}" + list.toString();
    }
}
