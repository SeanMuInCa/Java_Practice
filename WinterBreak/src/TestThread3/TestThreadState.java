package TestThread3;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/18 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestThreadState
{
    public static void main(String[] args) throws InterruptedException
    {
        int x = 0;
        T t = new T();
        System.out.println(t.getName() + " " + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState())
        {
            Thread.sleep(1000);
            System.out.println(t.getName() + " " + t.getState());
            if(x++ == 5)
            {
                t.setFlag(false);
            }
        }
        System.out.println(t.getName() + " " + t.getState());

    }
}
class T extends Thread
{
    boolean flag = true;

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        while (flag)
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("子线程运行中 " + i);
                //System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                try
                {
                    //System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                    Thread.sleep(1000);
                    //System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}