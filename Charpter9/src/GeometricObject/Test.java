package GeometricObject;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/13 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          GeometricObject <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class Test
{
    public static void main(String[] args)
    {
        Circle circle = new Circle(1);
        System.out.println("A circle " + circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("\nA rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
        System.out.println("------------------------------");
        showObject(rectangle);
        showObject(circle);
    }

    public static void showObject(GeometricObject obj)
    {
        System.out.println(obj);
    }
}
