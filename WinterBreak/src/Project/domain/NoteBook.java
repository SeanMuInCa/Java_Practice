package Project.domain;

/**
 * Purpose:             Project.domain<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    Project.domain<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.domain <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class NoteBook implements Equipment
{
    private String model;
    private double price;

    public NoteBook(String model, double price)
    {
        this.model = model;
        this.price = price;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    @Override
    public String getDescription()
    {
        return "PC: { Model: " + model + " , Price: " + price + " }";
    }
}
