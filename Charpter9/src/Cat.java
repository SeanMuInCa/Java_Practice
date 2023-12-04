import java.util.Objects;

/**
 * Purpose:             To output sum of two integers. <br />
 *                     To use run the main method. <br />
 * Data Submitted:      2023/11/7 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab1/Program1.java <br />
 * @author              George Ding (instructor - no SDC#)
 * @version            1.0.0
 */
public class Cat extends Animal{
    public boolean isNightVision()
    {
        return nightVision;
    }

    private boolean nightVision;
     public void shout(){
         System.out.println("meow,meow");
     }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return nightVision == cat.nightVision;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nightVision);
    }
}
