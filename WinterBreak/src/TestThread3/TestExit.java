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
//        Thread.sleep(3000);

        Th t2 = new Th();
        t2.start();
        t2.join();

//        t2.interrupt();
//        t2.setFlag(false);//叫停线程
//        System.out.println(thread.isFlag());
        //和interrupt不同，
        // 如果线城是休眠，那么interrupt是唤醒线程，让线程继续工作
        //如果线程是进行中，那么没有效果，除非你抛出异常
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
            /*if(n > 50) {
                this.interrupt();
                this.setFlag(false);
            }*/
            System.out.println(Thread.currentThread().getName() +" " + n++);
            try
            {
                Thread.sleep(50);

            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
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
