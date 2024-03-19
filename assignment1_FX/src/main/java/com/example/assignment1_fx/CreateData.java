package com.example.assignment1_fx;

import java.io.*;
import java.util.Arrays;

/**
 * Purpose:             com.example.assignment1_fx<br />
 * Data Submitted:      2024/3/18 <br />
 * Assignment Number:    com.example.assignment1_fx<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          com.example.assignment1_fx <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CreateData
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Student[] students = new Student[10];
        for (int i = 0; i < students.length - 2; i++)
        {
            students[i] = new Student((i + 1) + "", "mu" + (i + 1), "SDC", new String[]{"COSC602", "COSC603", "COSC604"});
        }
        students[students.length - 2] = new Student("666", "Mona", "SDC");
        students[students.length - 1] = new Student("999", "Sofia", "SDC");


        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objforarray.dat"));
        )
        {
            oos.writeObject(students);
        }


    }
}

class Student implements Serializable
{
    private final String studentNumber;
    private final String name;
    private final String program;
    private String[] courses = null;

    public Student(String studentNumber, String name, String program)
    {
        this.studentNumber = studentNumber;
        this.name = name;
        this.program = program;
    }

    public Student(String studentNumber, String name, String program, String[] courses)
    {
        this.studentNumber = studentNumber;
        this.name = name;
        this.program = program;
        this.courses = courses;
    }

    public String getStudentNumber()
    {
        return studentNumber;
    }



    public String getName()
    {
        return name;
    }



    public String getProgram()
    {
        return program;
    }



    public String[] getCourses()
    {
        return courses;
    }



    @Override
    public String toString()
    {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
