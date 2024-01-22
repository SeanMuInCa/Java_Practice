package Test06;

/**
 * Purpose:             Test06<br />
 * Data Submitted:      2023/12/11 <br />
 * Assignment Number:    Test06<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test06 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestAbstract
{
    public static void main(String[] args)
    {
        Temp t = new Temp();
        t.getTime();
    }
}

abstract class Template
{
    public void getTime()
    {
        long start = System.currentTimeMillis();
        method();//抽象方法，写的时候不确定要写什么，先放这，等明确了再写
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
    public abstract void method();
}

class Temp extends Template
{
    public void method()
    {
        for (int i = 2; i < 100000; i++)
        {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++)
            {
                if (i % j == 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                System.out.println(i);
            }
        }
    }
}
