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
public class Test01
{
    public static void main(String[] args)
    {
        /*这样我就可以每次都传不同的子类对象去实现不同的重写方法了。以后新加类的时候，也不用修改这些代码*/
        /*Animal animal = new Cat();
        animal.shout();
        Cat c = (Cat) animal;
        c.isNightVision();
        animal = new Dog();
        animal.shout();
        animal = new Animal();
        animal.shout();*/

        //对象工厂生产
        Animal a1 = AnimalProducer.createAnimal("cat");
        a1.shout();
        Animal a2 = AnimalProducer.createAnimal("dog");
        a2.shout();
    }
}
