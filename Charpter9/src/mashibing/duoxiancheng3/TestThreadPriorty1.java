package mashibing.duoxiancheng3;

public class TestThreadPriorty1 extends Thread
{
    @Override
    public void run()
    {
        for (int i = 20; i <=30 ; i++)
        {
            System.out.println(Thread.currentThread().getName()+"->"+i);
        }
    }
}

class Test1{
    public static void main(String[] args) throws InterruptedException
    {
        TestThreadPriorty t1 = new TestThreadPriorty();
        t1.setPriority(5);//1-10最低到最高
        t1.start();
        TestThreadPriorty1 t2 = new TestThreadPriorty1();
        t2.setPriority(10);
        t2.start();
        t2.join();
    }
}
