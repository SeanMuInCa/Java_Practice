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
public class Programmer extends Employee
{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment)
    {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }


    @Override
    public String toString()
    {
        return super.toString() + "\t" +"\tProgrammer\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
    public String getDetails(){
        return memberId + "/" + this.getId() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getSalary() + "\t\tProgrammer\t";
    }
}
