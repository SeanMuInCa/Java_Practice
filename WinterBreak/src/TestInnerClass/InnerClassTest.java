package TestInnerClass;

/**
 * Purpose:             TestInnerClass<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestInnerClass<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInnerClass <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class InnerClassTest
{
    public static void main(String[] args)
    {
        new Object(){//创建了一个匿名内部类并且实现了一个方法，并调用
            public void test(){
                System.out.println("test");
            }
        }.test();
    }
    /*
    * 为了好理解，我换成下面这个方式，就比较好说明白了
    * new Object().toString()这个是清晰可见的
    * new Object().test()这个不行，因为Object类里没有test方法，为了让他能调用
    * new Object(){
    *    public void test(){}
    * }.test()这样就没问题了，相当于实现了一个多态的子类，去实现了一下test方法，并调用
    *
    *
    * */
}

