package TestReflect;

import java.util.Scanner;

/**
 * Purpose:             TestReflect<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    TestReflect<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test
{
    public static void main(String[] args)
    {
        //定义一个字符串，模拟前端发过来的支付方式选择
        //每新增一个支付方式，就要新增一个判断分支外加支付方式
        //多态可以解决多个支付方式问题，但是判断分支还是要加
        //@see TestWithReflect
        Scanner sc = new Scanner(System.in);
        System.out.println("支付方式选择");
        String str = sc.next();
        if ("微信".equals(str))
        {
            //用微信支付
//            new Wechat().payOnline();
            pay(new Wechat());
        }
        if ("支付宝".equals(str))
        {
            //用支付宝支付
//            new AliPay().payOnline();
            pay(new AliPay());
        }
        if("银行".equals(str)){
            pay(new Bank());
        }
    }
    public static void pay(Meituanwaimai m){
        m.payOnline();
    }

   /*这样太麻烦了，我要用多态试试
   private static void pay(Bank bank)
    {
        bank.payOnline();
    }

    public static void pay(Wechat w){
        w.payOnline();
    }
    public static void pay(AliPay a){
        a.payOnline();
    }*/
}
