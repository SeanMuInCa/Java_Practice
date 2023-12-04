import java.util.Arrays;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/12 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class StackOfIntegers
{
    private int[] elements;
    private int size;

    public static final int DEFAULT_CAPACITY = 16;
    public StackOfIntegers()
    {
        this(DEFAULT_CAPACITY);
    }
    public StackOfIntegers(int capacity)
    {
        this.elements = new int[capacity];
    }
    public boolean empty() {
        return this.size == 0;
    }
    public int peek(){
        return elements[size - 1];
    }
    public void push(int value){
        if(this.size >= this.elements.length){
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements,0,temp, 0,elements.length);
            elements = temp;
        }
        this.elements[size++] = value;
    }
    public int pop(){
        return this.elements[--size];
    }
    public int getSize(){
        return this.size;
    }

    @Override
    public String toString()
    {
        return "StackOfIntegers{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
