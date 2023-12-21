package TestMap;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestTreeMap
{
    @Test
    public void test(){
        TreeMap map = new TreeMap<>();

        map.put("cc",89);
        map.put("bb",90);
        map.put("aa",91);
        map.put("dd","abc");//key类型要一致

        for (Object o : map.entrySet())
        {
            System.out.println(o);//根据key排序
        }

    }
    @Test
    public void test2(){
        TreeMap map = new TreeMap<>();
        Student s1 = new Student("raina",22);
        Student s2 = new Student("tom",33);
        Student s3 = new Student("jerry",21);
        Student s4 = new Student("sean",24);
        Student s5 = new Student("vicent",27);

        map.put(s1,99);
        map.put(s2,66);
        map.put(s3,57);
        map.put(s4,90);
        map.put(s5,88);

        for (Object o : map.entrySet())
        {
            System.out.println(o);
        }

    }
    @Test
    public void test3(){

        Comparator<Student> comparator = new Comparator()
        {

            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof Student && o2 instanceof Student){
                    return ((Student)o1).getAge() - ((Student)o2).getAge();
                }
                else {
                    throw new RuntimeException("类型不一致");
                }
            }
        };

        TreeMap map = new TreeMap<>(comparator);
        Student s1 = new Student("raina",22);
        Student s2 = new Student("tom",33);
        Student s3 = new Student("jerry",22);
        Student s4 = new Student("sean",24);//外部比较器，导致该数据无法加入
        Student s5 = new Student("vicent",27);

        map.put(s1,99);
        map.put(s2,66);
        map.put(s3,57);
        map.put(s4,90);
        map.put(s5,88);

        for (Object o : map.entrySet())
        {
            System.out.println(o);
        }
    }
}
class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age)
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o)
    {
        int value = this.age - o.age;
        if(value == 0){
            return this.name.compareTo(o.name);
        }else{
            return value;
        }
    }
}