package TestCollection;

import org.junit.Test;

import java.util.*;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/19 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * collection中的方法
 */
public class Test1
{
    @Test
    public void test(){
        Collection col = new ArrayList();
        col.add("a");
        col.add("b");
        col.add(1);
        col.add(new Object());
        col.add(new Person("zs",19));
        for (Object obj : col)
        {
            System.out.println(obj);
        }

        Collection col1 = new ArrayList();
        col1.add("abcd");
        col1.add(1234);
        col1.addAll(col);
        for (Object obj : col1)
        {
            System.out.println(obj);
        }
        System.out.println(col1.size());
    }
    @Test
    public void test2(){
        Collection col = new ArrayList();
        col.add("a");
        col.add("b");
        col.add(1);
        col.add(new Person("zs",19));
        Person p = new Person("ls",20);


        /*System.out.println(col.isEmpty());
        System.out.println(col.contains(1));
        System.out.println(col.contains(p));*/
        System.out.println(col.contains(new Person("zs",19)));

        Collection col1 = new ArrayList();
        col1.add(p);
        col1.add("a");
        col1.add("b");
        col1.add(1);
        col1.add(new Person("zs",19));
        System.out.println(col1.containsAll(col));

    }
    //删除
    @Test
    public void test3(){
        Collection col = new ArrayList();
        col.add("a");
        col.add("b");
        col.add(1);
        col.add(new Person("zs",19));
        Person p = new Person("ls",20);
        col.add(p);
        System.out.println(col);
        /*col.clear();
        System.out.println(col);*/
        col.remove("a");
        System.out.println(col);
        Collection col1 = new ArrayList();
        col1.add(p);
        col1.add("a");
        col1.add("b");
        col1.add(1);
        col1.add(new Person("zs",19));
//        col1.removeAll(col);
        col1.retainAll(col);
        System.out.println(col1);
    }
    @Test
    public void test4(){
        Collection col1 = new ArrayList();
        col1.add("a");
        col1.add("b");
        col1.add(1);
        col1.add(new Person("zs",19));

        Object[] array = col1.toArray();//list ----> array
        System.out.println(Arrays.toString(array));

        String[] arr = new String[]{"a","b","raina"};
        List<String> list = Arrays.asList(arr);//array ----> list
        System.out.println(list);
    }
}
class Person{
    private String name;
    private int age;

    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
}