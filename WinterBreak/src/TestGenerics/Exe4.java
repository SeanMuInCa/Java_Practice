package TestGenerics;

import java.util.Iterator;
import java.util.Objects;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2023/12/22 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe4
{
    public static void main(String[] args)
    {
        Students<String> s1 = new Students<>("raina", "Perfect");
        Students<Double> s2 = new Students<>("raina1", 99.4);
        Students<Character> s3 = new Students<>("raina2", 'B');
    }
}
class Students<E>{
    private String name;
    private E grade;//有的老师是用优秀来定义成绩，有的是分数，有的是字母

    public Students()
    {
    }

    public Students(String name, E grade)
    {
        this.name = name;
        this.grade = grade;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public E getGrade()
    {
        return grade;
    }

    public void setGrade(E grade)
    {
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return "Students{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students<?> students = (Students<?>) o;
        return Objects.equals(name, students.name) && Objects.equals(grade, students.grade);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, grade);
    }
}