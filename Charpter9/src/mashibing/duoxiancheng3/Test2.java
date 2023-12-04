package mashibing.duoxiancheng3;

/**
 * Purpose:             mashibing.duoxiancheng3<br />
 * Data Submitted:      2023/11/26 <br />
 * Assignment Number:    mashibing.duoxiancheng3<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test2
{
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 1; i <= 10; i++)
        {
            if(i == 3){
                TestThreadPriorty1 t = new TestThreadPriorty1();
                t.start();
                t.join();//先执行完才会继续其他线程
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
