package test02;

/**
 * Purpose:             test02<br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    test02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          test02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Boy
{
    private String name;
    private int age;

    public Boy()
    {
    }

    public Boy(String name, int age)
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
    public void shout(){
        System.out.println(name + " is shouting ");
    }
    public void marry(Girl girl){
        System.out.println("marry " + girl.getName());
    }
}
