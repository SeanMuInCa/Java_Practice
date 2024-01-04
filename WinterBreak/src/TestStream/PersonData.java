package TestStream;

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
        return List.of(
                new Person("raina", 14,1),
                new Person("lily", 15,2),
                new Person("tom", 16,3),
                new Person("jerry", 17,4),
                new Person("alice", 18,5),
                new Person("bob", 19,6),
                new Person("charles", 20,7),
                new Person("david", 21,8),
                new Person("evelyn", 22,9));
    }
}
