package mashibing.duoxiancheng1;

/**
 * Purpose:             mashibing.duoxiancheng<br />
 * Data Submitted:      2023/11/26 <br />
 * Assignment Number:    mashibing.duoxiancheng<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class BuyTicketsThread extends Thread
{
    static int availableTickets = 10;//static确保多个对象共享票数
    BuyTicketsThread(String name) {
        super(name);
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
           if(availableTickets > 0){
               System.out.println("i got the " + availableTickets-- + " ticket from " + this.getName() + "counter!");
           }
        }
    }
}
