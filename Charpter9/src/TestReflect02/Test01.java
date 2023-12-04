package TestReflect02;

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
public class Test01
{
    //获取字节码信息的方式
    public static void main(String[] args) throws ClassNotFoundException
    {
        //以Person为例
        //方式1 getClass() 不常用
        Person person = new Person();
        Class c = person.getClass();
        System.out.println(c);

        //方式2  内置class属性  不常用
        Class c2 = Person.class;
        System.out.println(c2);

        //方式3 *****  通过传包地址获取  最常用
        Class c3 = Class.forName("TestReflect02.Person");
        System.out.println(c3);

        //方式4  了解即可  通过类的加载器
        ClassLoader cl = Test01.class.getClassLoader();
        Class c4 = cl.loadClass("TestReflect02.Person");
        System.out.println(c4);

    }
}
