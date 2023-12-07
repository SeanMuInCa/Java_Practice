package test01;

/**
 * Purpose:             test01<br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    test01<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          test01 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Student
{
    private String name;
    private int age;
    private String gender;
    public static String teacherName;

    public Student()
    {
    }

    public Student(String name, int age, String gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void study(){
        System.out.println(name + " is studying");
    }
    public void show(){
        System.out.println(name + ' ' + age + ' ' + gender + ' ' + teacherName);
    }
}
