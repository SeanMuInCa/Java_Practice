package TestStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/1/4 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class PersonData
{
    public static List<Person> getPersonList()
    {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("raina1", 14, 1));
        personList.add(new Person("raina2", 15, 2));
        personList.add(new Person("raina3", 16, 3));
        personList.add(new Person("raina4", 17, 4));
        personList.add(new Person("raina5", 18, 5));
        personList.add(new Person("raina6", 19, 6));
        personList.add(new Person("raina7", 20, 7));
        personList.add(new Person("raina8", 21, 8));
        personList.add(new Person("raina9", 22, 9));
        personList.add(new Person("raina10", 23, 10));
        personList.add(new Person("ray", 23, 11));

        return personList;
    }
}