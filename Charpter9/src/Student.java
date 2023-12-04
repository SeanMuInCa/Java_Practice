import java.util.Objects;

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
public class Student extends Person
{
    private int number;
    public Student(String name, int age, String gender,int number)
    {
        super(name, age, gender);
        this.number= number;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(number);
    }
}
