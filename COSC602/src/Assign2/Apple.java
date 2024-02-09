package Assign2;

public class Apple implements Cloneable
{
    private String sColor, sName;
    private int nLotNumber;

    private double dPrice;
    private double dWeight;




    public Apple(int nLot, String sName,  String sColor, double dWeight, double dPrice)
    {
        this.nLotNumber = nLot;
        this.sColor = sColor;
        this.dWeight = dWeight;
        this.dPrice = dPrice;
        this.sName = sName;
    }

    public Apple(Apple obOther)
    {
        this.sColor = obOther.sColor;
        this.dPrice = obOther.getPrice();
        this.sColor = obOther.getColor();
        this.sName = obOther.sName;
        this.nLotNumber = obOther.nLotNumber;

    }

    public String getName()
    {
        return this.sName;

    }

    public int getLot()
    {
        return this.nLotNumber;
    }

    public String getColor()
    {
        return this.sColor;
    }

    public double getPrice()
    {
        return this.dPrice;

    }

    public double getWeight()
    {
        return this.dWeight;
    }

    @Override
    public Object clone()
    {
        try
        {
            return  super.clone();

        }
        catch(CloneNotSupportedException exp)
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return String.format("Lot: %2d Name: %-20sColor: %-10sWeight: %6.2f Cost $%.2f", this.nLotNumber, this.sName, this.sColor, this.dWeight, this.dPrice);
    }


}