package TestInterface;

/**
 * Purpose:             TestInterface<br />
 * Data Submitted:      2023/12/11 <br />
 * Assignment Number:    TestInterface<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInterface <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class USBTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Computer computer = new Computer();
        //方式1 具名类或者接口等于实现类
        /*USB usb1 = new Printer();
        USB usb2 = new Scanner();*/
        Printer usb1 = new Printer();
        computer.transfer(usb1);
        //方式2，匿名类
        computer.transfer(new Scanner());
        //方式3 接口匿名实现类
        USB usb3 = new USB()
        {
            @Override
            public void start()
            {
                System.out.println("usb3 start");
            }

            @Override
            public void stop()
            {
                System.out.println("usb3 stop");
            }
        };
        computer.transfer(usb3);
    }
}

class Computer
{
    public void transfer(USB usb) throws InterruptedException
    {
        System.out.println("computer connected a usb device");
        Thread.sleep(1000);
        usb.start();
        System.out.println("data transferring...");
        Thread.sleep(1000);
        usb.stop();
    }
}

class Scanner implements USB
{
    @Override
    public void start()
    {
        System.out.println("scanner start");
    }

    @Override
    public void stop()
    {
        System.out.println("scanner stop");
    }
}
class Printer implements USB
{
    @Override
    public void start()
    {
        System.out.println("printer start");
    }

    @Override
    public void stop()
    {
        System.out.println("printer stop");
    }
}

interface USB
{
    public abstract void start();

    void stop();//可省略
}