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
public class TestThread extends Thread//多线程
{
    /*
    * 任务要放在run中
    * 放在这里就意味着要开多线程来干一个事，这个事就是任务
    * run方法不能直接调用
    * */
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(super.getName() + i);
        }
    }
}
