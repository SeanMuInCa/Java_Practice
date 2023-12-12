package TestInnerClass;

/**
 * Purpose:             TestInnerClass<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestInnerClass<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInnerClass <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class OuterClassTest
{
    public static void main(String[] args)
    {
        //1.创建静态内部类实例
        Person.Dog dog = new Person.Dog();//静态类也是随着外部类加载而加载，所以不用实例
        System.out.println(dog);
        //2创建非静态内部类实例
        Person.Cat cat = new Person().new Cat();//非静态的，必须要通过外部类实例加载
        System.out.println(cat);
    }
}
class Person{//outer class
    static class Dog{//静态成员内部类，这个类仅供外部类使用，不会被其他类使用，因此定义为内部类

        @Override
        public String toString()
        {
            return "Dog{}";
        }
    }
    class Cat{//非静态成员内部类，

        @Override
        public String toString()
        {
            return "Cat{}";
        }
    }
    public void method(){
        class InnerClass{//局部内部类，

        }
    }
    public Person(){
        class InnerClass{//局部内部类，

        }

    }
}