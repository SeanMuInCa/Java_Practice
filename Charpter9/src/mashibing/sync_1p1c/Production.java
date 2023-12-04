package mashibing.sync_1p1c;

/**
 * Purpose:             mashibing.sync<br />
 * Data Submitted:      2023/11/30 <br />
 * Assignment Number:    mashibing.sync<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.sync <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Production
{
    private String brand;
    private String name;
    boolean flag = false;//是否有商品可消费

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public synchronized void product(String brand, String name)
    {
        if (this.flag)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        this.setBrand(brand);
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        this.setName(name);
        System.out.println("生产者，生产了" + this.getBrand() + " 的----" + this.getName());
        this.flag = true;
        notify();
    }

    public synchronized void consume()
    {
        if (!this.flag)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        System.out.println("消费者，消费了" + this.getBrand() + "的---" + this.getName());
        this.flag = false;
        notify();
    }
}
