package TestException;

/**
 * Purpose:             TestException<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    TestException<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestException <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ReturnExceptionDemo
{
    static void methodA() throws Exception{
        try
        {
            System.out.println("Enter method A");
            throw new Exception("Exception");//如果抛出了异常，后面的代码不执行了
        }finally
        {
            System.out.println("finally in method A");
        }
    }
    static void methodB(){
        try
        {
            System.out.println("Enter method B");
            return;
        }finally
        {
            System.out.println("finally in method B");
        }
    }

    public static void main(String[] args)
    {
        try
        {
            methodA();
        }catch (Exception e){
            System.out.println(e.getMessage());//这里打印的是A中抛出的异常信息
        }
        methodB();
    }
}
