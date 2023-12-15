package Project.domain;

import Project.service.Status;

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
public class Designer extends Programmer
{
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus)
    {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    @Override
    public String toString()
    {
        return super.getDes()+ "\tDesigner\t" + this.getStatus() + "\t" + this.getBonus() + "\t\t\t" + this.getEquipment().getDescription();
    }
}
