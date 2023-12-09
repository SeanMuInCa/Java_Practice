package Test05;

/**
 * Purpose:             Test05<br />
 * Data Submitted:      2023/12/9 <br />
 * Assignment Number:    Test05<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test05 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestPerson
{
    public static void meeting(Person... p){
        for (Person person : p)
        {
            person.eat();
            person.toilet();
            if (person instanceof Man) ((Man) person).smoke();
            if (person instanceof Woman) ((Woman) person).makeup();
        }
    }

    public static void main(String[] args)
    {
        Man m1 = new Man();
        Man m2 = new Man();
        Man m3 = new Man();

        Woman w1 = new Woman();
        Woman w2 = new Woman();
        Woman w3 = new Woman();

        meeting(m1,m2,m3,w1,w2,w3);


    }
}
