package Lab3.Q3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose:             Lab3.Q3<br />
 * Data Submitted:      2024/1/27 <br />
 * Assignment Number:    Lab3.Q3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3.Q3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class A
{
    public static void main(String[] args)
    {
        ArrayList<Person> list = new ArrayList<>();
        getUserInput(list,3);
        writeToFile(list,"User.data");
    }

    private static void writeToFile(ArrayList<Person> list,String s)
    {
        BufferedWriter bw = null;
        try
        {
            bw = new BufferedWriter(new FileWriter(new File(s)));
            for (Person p : list)
            {
                String lName = p.getName().split(",")[0];
                String fName = p.getName().split(",")[1];
                String str = (fName +"," + lName + "," + p.getAge() + "," + p.getSin());
                bw.write(str);
                bw.newLine();
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }finally
        {
            try
            {
                if(bw != null)
                    bw.close();
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getUserInput(ArrayList<Person> list, int num)
    {
        System.out.println("Please input " + num + " person data: ");
        int index = num;
        do
        {
            System.out.println("Input first name:");
            Scanner input = new Scanner(System.in);
            String fName = input.next();

            System.out.println("Input last name: ");
            String lName = input.next();

            System.out.println("Input your age: ");
            int age = input.nextInt();

            System.out.println("Input your sin: ");
            long sin = input.nextLong();

            System.out.println("Your " + (index - num + 1) +" user's info is " + fName + " " + lName + " age: " + age + " sin: " + sin);
            Person p = new Person(fName,lName);
            p.setAge(age);
            p.setSin(sin);
            list.add(p);
        }while (num-- != 0);
    }
}
