/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/7 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab1/Program1.java <br />
 *
 * @author George Ding (instructor - no SDC#)
 * @version 1.0.0
 */
public class AnimalProducer
{
    public static Animal createAnimal(String name) {
        Animal animal = null;
        if("cat".equals(name))
            animal = new Cat();
        if("dog".equals(name))
            animal = new Dog();
        return animal;
    }
}
