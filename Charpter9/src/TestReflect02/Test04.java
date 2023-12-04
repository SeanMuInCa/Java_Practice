package TestReflect02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Purpose:             TestReflect02<br />
 * Data Submitted:      2023/12/4 <br />
 * Assignment Number:    TestReflect02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test04
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        //利用反射获取方法并调用方法
        //获取字节码信息
        Class c1 = Class.forName("TestReflect02.Student");
        //获取所有public方法以及父类的public方法，包括Object父类
        Method[] methods = c1.getMethods();
        for (Method method : methods){
            System.out.println(method);
        }
        System.out.println("---------------------------------");
        //获取所有非public方法
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods){
            System.out.println(declaredMethod);
        }
        System.out.println("---------------------------------");
        //创建一个对象
        Constructor constructor = c1.getConstructor();
        Object o = constructor.newInstance();
        Method myMethod = c1.getMethod("showInfo",int.class,int.class);
//        System.out.println(myMethod);
        System.out.println(myMethod.invoke(o, 10, 10));
        System.out.println("---------------------------------");
        //创建对象并给属性赋值
        Constructor constructor1 = c1.getDeclaredConstructor(int.class, double.class, double.class);
        Object obj1 = constructor1.newInstance(200,150.5,180.5);
        Method m = c1.getDeclaredMethod("work");
        m.setAccessible(true);
        m.invoke(obj1);
        System.out.println("---------------------------------");
        //获取方法具体结构
        //修饰符，返回值类型，方法名，参数列表，异常，注解
        System.out.println(m.getName());
        System.out.println(m.getReturnType());
        System.out.println(Modifier.toString(m.getModifiers()));
        System.out.println(Arrays.toString(m.getExceptionTypes()));
        System.out.println(m.getParameterCount());
        System.out.println(Arrays.toString(myMethod.getParameterTypes()));
        System.out.println("---------------------------------");
        Method myMethod1 = c1.getMethod("myMethod");
        //获取注解，只能获取runtime的注解，如果是其他的注解无法获取
        Annotation[] annotations = myMethod1.getDeclaredAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation.toString());
        }
//        System.out.println(c1.newInstance());
    }
}
