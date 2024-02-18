package TestThread3;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/17 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestExit
{
    public static void main(String[] args) throws InterruptedException
    {

        Th thread = new Th();
        thread.start();
        Thread.sleep(3000);
        thread.setFlag(false);//叫停线程
    }
}
class Th extends Thread
{
    int n = 0;
    boolean flag = true;
    @Override
    public void run()
    {

        while (flag)
        {
            System.out.println(Thread.currentThread().getName() + n++);
            try
            {
                Thread.sleep(50);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
}
