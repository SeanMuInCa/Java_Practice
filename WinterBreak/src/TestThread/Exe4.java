package TestThread;

/**
 * Purpose:             TestThread<br />
 * Data Submitted:      2023/12/15 <br />
 * Assignment Number:    TestThread<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe4
{
    public static void main(String[] args)
    {
        A a = new A();
        a.start();

        B b = new B(a);
        b.start();
    }
}
class A extends Thread{
    @Override
    public void run()
    {
        System.out.println("A run...");
    }
}
class B extends Thread{
    private A a;
    public B(A a)
    {
        this.a = a;
    }

    @Override
    public void run()
    {
        System.out.println("B run...");
    }
}
