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
public class Architect extends Designer
{
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock)
    {
        super(id, name, age, salary, equipment,bonus);
        this.stock = stock;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    @Override
    public String toString()
    {
        return getDes() + "\t" +"\tArchitect\t" + this.getStatus() + "\t" + this.getBonus() + "\t" + this.getStock() + "\t" + this.getEquipment().getDescription();
    }
    public String getDetails(){
        return this.getMemberId() + "/" + this.getId() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getSalary() + "\t\tArchitect\t" + this.getBonus() + "\t" + this.getStock();
    }
}
