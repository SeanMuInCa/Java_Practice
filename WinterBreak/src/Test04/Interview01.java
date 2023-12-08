package Test04;

/**
 * Purpose:             Test04<br />
 * Data Submitted:      2023/12/8 <br />
 * Assignment Number:    Test04<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test04 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Interview01
{
    public static void main(String[] args)
    {
        new A(new B());
    }
}
class A{
    public A(){
        System.out.println("A");
    }
    public A(B b){
        this();
        System.out.println("AB");
    }
}
/*class B{
    public B()
    {
        System.out.println("B");
    }
}*/
class B extends A{
    public B()
    {
        System.out.println("B");
    }
}
