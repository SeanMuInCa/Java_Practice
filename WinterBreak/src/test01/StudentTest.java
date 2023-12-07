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
public class StudentTest
{
    public static void main(String[] args)
    {
        Student s1 = new Student();
        Student s2 = new Student("def",17,"female");
        s1.setName("abc");
        s1.setAge(18);
        s1.setGender("male");
        Student.teacherName = "ding";

        s1.study();
        s1.show();

        s2.study();
        s2.show();
    }
}
