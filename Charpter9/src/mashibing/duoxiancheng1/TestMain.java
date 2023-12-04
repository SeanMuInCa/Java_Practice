package mashibing.duoxiancheng1;

/**
 * Purpose:             mashibing.duoxiancheng<br />
 * Data Submitted:      2023/11/25 <br />
 * Assignment Number:    mashibing.duoxiancheng<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestMain
{
    public static void main(String[] args)
    {
        //这样就能出现两个线程交叉进行的情况
        TestThread tt = new TestThread();
        tt.setName("raina ");
        tt.start();
        for (int i = 0; i < 10; i++)
        {
            Thread.currentThread().setName("main ");
            System.out.println(Thread.currentThread().getName() + i);
        }

    }
}
