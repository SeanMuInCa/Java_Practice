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
public class Demo
{
    public static void main(String[] args)
    {
        /*
        * Class类的具体实力
        * 1. 类，外部类，内部类
        * 2. 接口
        * 3. 注解
        * 4. 数组
        * 5. 基本数据类型
        * 6. void
        * */
        Class c = Person.class;//证明1
        Class c2 = Comparable.class;//证明2
        Class c3 = Override.class;//证明3
        int[] arr = {1,2,3};
        int[] arr2 = {4,5,6};
        Class c4 = arr.getClass();//证明4
        Class c5 = arr2.getClass();//证明4
        System.out.println(c4 == c5);//同维度，同类型数组，字节码就是相同

        Class c6 = int.class;//证明5
        Class c7 = void.class;//证明6
    }
}
