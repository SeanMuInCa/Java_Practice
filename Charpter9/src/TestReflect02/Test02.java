package TestReflect02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Purpose:             TestReflect02<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    TestReflect02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test02
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        //利用反射获取构造器并创建对象
        //获取字节码信息
        Class c1 = Class.forName("TestReflect02.Student");
        //这个只能拿到public构造器
        Constructor[] constructors = c1.getConstructors();
        System.out.println(constructors.length);
        for (Constructor constructor : constructors)
        {
            System.out.println(constructor);
        }
        System.out.println("---------------------");
        //这个能拿到所有构造器
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for(Constructor c :declaredConstructors){
            System.out.println(c);
        }
        System.out.println("---------------------");
        //获取指定构造器
        //不传参数，就是要获取Public 的空构造器
        Constructor constructor = c1.getConstructor();
        System.out.println(constructor);

        //得到两个参数的构造器 public的
        Constructor constructor1 = c1.getConstructor(double.class, double.class);
        System.out.println(constructor1);

        //得到一个参数的构造器 private的
        Constructor constructor2 = c1.getDeclaredConstructor(int.class);
        System.out.println(constructor2);

        //如要获取public的就用普通的，如果不是public就要用declare的
        //有了构造器，就可以创建对象了
        //public的可以直接这么创建
        Object obj1 = constructor.newInstance();
        System.out.println(obj1);
        //public的可以直接这么创建
        Object obj2 = constructor1.newInstance(170.5,180.5);
        System.out.println(obj2);

        //使用非public的构造器创建示例
        constructor2.setAccessible(true);
        Object obj3 = constructor2.newInstance(100);
        System.out.println(obj3);
    }
}
