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
public class Girl
{
    private String name;
    private int age;

    public Girl()
    {
    }

    public Girl(String name, int age)
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
    public void marry(Boy boy){
        System.out.println("marry with "+ boy.getName());
    }
    public int compare(Girl g){
        return this.getName().compareTo(g.getName());
    }
}
