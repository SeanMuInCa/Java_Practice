package TestReflect02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

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
public class Test03
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
    {
        //利用反射获取属性，并给属性赋值
        //获取字节码信息
        Class c1 = Class.forName("TestReflect02.Student");
        //只能获取public属性，还有父类的
        Field[] c1Fields = c1.getFields();
        for (Field f :c1Fields){
            System.out.println(f);
        }
        System.out.println("---------------------");
        //获取所有属性
        Field[] fields = c1.getDeclaredFields();
        for (Field f :fields){
            System.out.println(f);
        }
        System.out.println("---------------------");
        //获取指定public属性
        Field score = c1.getField("score");
        System.out.println(score);

        //获取指定非public属性
        Field studentId = c1.getDeclaredField("studentId");
        System.out.println(studentId);

        System.out.println("---------------------");

        //属性的结构
        //获取修饰符
        int modifiers = studentId.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers));

        //获取属性的数据类型
        Class type = studentId.getType();
        System.out.println(type.getName());

        //获取属性名字
        String name = studentId.getName();
        System.out.println(name);
        System.out.println("---------------------");

        //创建对象并给属性赋值
        Constructor constructor = c1.getDeclaredConstructor(int.class, double.class, double.class);
        Object obj1 = constructor.newInstance(200,150.5,180.5);
        studentId.setAccessible(true);
        score.setDouble(obj1,87.5);
        studentId.setInt(obj1,2002);
        System.out.println(obj1);
    }
}
