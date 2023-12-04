package TestReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class TestWithReflect
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("支付方式选择");
        String input = sc.next();
        String str = "";
        if ("微信".equals(input))
        {
            str = "TestReflect.Wechat";
        }
        if ("支付宝".equals(input))
        {
            str = "TestReflect.AliPay";
        }
        if ("银行卡".equals(input))
        {
            str = "TestReflect.Bank";
        }
        //反射
        Class aClass = Class.forName(str);

        Object o = aClass.newInstance();
        Method m1 = aClass.getMethod("payOnline");
        m1.invoke(o);
    }
}
