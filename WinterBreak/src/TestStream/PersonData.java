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
                new Person(1, "John"),
                new Person(2, "Mary"),
                new Person(3, "Bob"),
                new Person(4, "Alice"),
                new Person(5, "David"),
                new Person(6, "Sara"),
                new Person(7, "Mike"),
                new Person(8, "Lily"),
                new Person(9, "Tom"),
                new Person(10, "Jack"));
    }
}
