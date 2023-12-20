package TestCollection;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class StudentInfo
{
    public static void main(String[] args)
    {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("----Student Info System---");
            System.out.println("Input press 1, press 0 to quit: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("input student's name: ");
                String name = sc.next();
                System.out.println("input student's age: ");
                int age = sc.nextInt();
                Student student = new Student(name, age);
                if(!list.contains(student)){
                    list.add(new Student(name, age));
                }else{
                    System.out.println("this student is already in the list");
                }
            }else{
                break;
            }
        }
        System.out.println("Students info: ");
        for (Student student : list)
        {
            System.out.println(student);
        }
    }
}
class Student{
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
}