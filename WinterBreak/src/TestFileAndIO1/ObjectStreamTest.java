package TestFileAndIO1;

import org.junit.Test;

import java.io.*;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2023/12/24 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * //serialize             deserialize
 * ObjectOutputStream and ObjectInputStream are used to serialize and deserialize objects.
 */
public class ObjectStreamTest
{
    @Test
    public void test() throws IOException
    {
        File file = new File("object.data");//我可以自定义文件了
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //serialize
        oos.writeUTF("i love java");
        oos.writeObject(new Student("raina", 14));
        oos.writeObject(new Student("raina1", 15));
        oos.close();
    }

    @Test
    public void test1() throws IOException, ClassNotFoundException
    {
        File file = new File("object.data");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        //deserialize
        /*String s = ois.readUTF();
        Object o = ois.readObject();
        System.out.println(s);
        System.out.println(o);*/


        try
        {
            while (true){
                String s = ois.readUTF();
                System.out.println(s);
                Object obj = ois.readObject();
                System.out.println(obj);
                Object obj1 = ois.readObject();
                System.out.println(obj1);
            }

        } catch (EOFException e)
        {
            System.out.println("done");
        } finally
        {
            ois.close();
        }
    }

}

class Student implements Serializable
{

    public static final long serialVersionUID = 1241251251212L;
    private String name;
    private int age;

    public Student(String name, int age)
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

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}