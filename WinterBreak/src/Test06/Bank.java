package Test06;

/**
 * Purpose:             Test06<br />
 * Data Submitted:      2023/12/10 <br />
 * Assignment Number:    Test06<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test06 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Bank//单例模式
{
    //1构造器私有化
    private Bank(){}
    //2.在内部创建一个实例
    private static Bank bank = new Bank();

    //3.提供一个静态方法，返回实例
    public static Bank getInstance(){
        return bank;
    }
}
