package mashibing.duoxiancheng4;

/**
 * Purpose:             mashibing.duoxiancheng4<br />
 * Data Submitted:      2023/11/29 <br />
 * Assignment Number:    mashibing.duoxiancheng4<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng4 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestsetDaemon
{
    public static void main(String[] args)
    {
        TestThread tt = new TestThread();
        tt.setDaemon(true);//设置伴随线程，先设置再启动。理解为皇帝死了，妃子陪葬，但是妃子不是马上陪葬，中间有个延迟
        tt.start();//这个线程循环1000次，时间很长。而主线程只有10次，太短了。设置伴随线程，可以在一个线程结束时，另一个也结束。

        for (int i = 1; i < 11; i++)
        {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
