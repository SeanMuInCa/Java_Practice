package mashibing.duoxiancheng3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
public class TestThread3 implements Callable<Integer>
{
    /*
    * 这玩意要有泛型，要重写call方法，且泛型类型对应call返回值
    * 能抛出异常
    *
    * */

    @Override
    public Integer call() throws Exception
    {
        return new Random().nextInt(10);//10以内的随机数
    }
}
class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        TestThread3 t = new TestThread3();
        FutureTask ft = new FutureTask(t);
        Thread tt = new Thread(ft);
        tt.start();

        //获取call的返回值
        Object obj = ft.get();
        System.out.println(obj);
    }
}