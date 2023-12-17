package TestThread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Purpose:             TestThread2<br />
 * Data Submitted:      2023/12/17 <br />
 * Assignment Number:    TestThread2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 这里不需要thread了，直接使用线程池
 */
public class ThreadPool
{
    public static void main(String[] args)
    {
        //1. 提供指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        //设置线程池的属性
        System.out.println(executorService.getClass());
        service.setMaximumPoolSize(50);//设置上限

        //2执行指定的线程操作，用runnable或者callable的实现类
        executorService.execute(new NumberThread());
        executorService.execute(new NumberThread1());

        //3.关闭连接池
        executorService.shutdown();
    }
}
class NumberThread implements Runnable{
    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}