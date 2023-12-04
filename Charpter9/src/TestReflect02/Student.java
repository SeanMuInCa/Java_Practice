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
public class Student extends Person
{
    private int studentId;
    double height;
    protected double weight;
    public double score;

    public String showInfo()
    {
        return "i am a student";
    }

    private void work()
    {
        System.out.println("i find a job");
    }

    public Student()
    {
        System.out.println("non-param constructor");
    }

    private Student(int studentId)
    {
        this.studentId = studentId;
    }
    Student(int studentId,double weight){
        this.studentId = studentId;
        this.weight = weight;
    }
}
