/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/6 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab1/Program1.java <br />
 *
 * @author George Ding (instructor - no SDC#)
 * @version 1.0.0
 */
public class Person
{
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender)
    {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
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
    public void speak(String words){
        System.out.println(words);
    }
}
