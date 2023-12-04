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
public class Circle extends GeometricObject
{
    private double radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius)
    {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
    public double getPerimeter(){
        return this.radius * Math.PI * 2;
    }
    public double getDiameter(){
        return this.radius * 2;
    }
    public void printCircle() {

    }

    @Override
    public String toString()
    {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
