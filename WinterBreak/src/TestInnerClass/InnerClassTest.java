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
}

