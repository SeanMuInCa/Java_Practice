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
public class Rectangle extends GeometricObject
{
    private double width;
    private double height;

    public Rectangle()
    {
    }

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height)
    {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }
    public double getArea(){
        return this.width * this.height;
    }
    public double getPerimeter(){
        return (this.width + this.height) * 2;
    }

    @Override
    public String toString()
    {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }
}
