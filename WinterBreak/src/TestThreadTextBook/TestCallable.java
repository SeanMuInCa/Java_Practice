package TestThreadTextBook;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/12 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestCallable
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        //callable有返回值，可以抛出异常，还是一个泛型方法
        //相比较runable没有返回值也不能抛出异常
        //用funtureTask来接收返回值
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(myCallable);//这个也实现了runable接口

        new Thread(integerFutureTask).start();
        System.out.println(integerFutureTask.get());
    }
}
class MyCallable implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        int sum = 0;
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}