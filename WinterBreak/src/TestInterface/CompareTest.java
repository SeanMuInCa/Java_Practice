package TestInterface;

/**
 * Purpose:             TestInterface<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestInterface<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInterface <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CompareTest
{
    public static void main(String[] args)
    {
        ComparableCircle c1 = new ComparableCircle();
        c1.setRadius(10);
        ComparableCircle c2 = new ComparableCircle();
        c2.setRadius(12);
        System.out.println(c1.compareTo(c2));

    }
}

interface CompareObject
{
    int compareTo(Object o);
}

class Circle
{
    private double radius;

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
}

class ComparableCircle extends Circle implements CompareObject
{
    @Override
    public int compareTo(Object o)
    {
        if (o instanceof ComparableCircle c)
        {
            return Double.compare(this.getRadius(), c.getRadius());
        } else
        {
            return 0;
        }
    }
}
