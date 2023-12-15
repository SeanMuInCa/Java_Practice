package Project.service;

import Project.domain.*;
import org.junit.Test;

/**
 * Purpose:             Project.service<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    Project.service<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.service <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class NameListService
{
    private Employee[] employees;

    public NameListService()
    {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++)
        {
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            switch (type)
            {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(Data.EQUIPMENTS[i]);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(Data.EQUIPMENTS[i]);
                    employees[i] = new Designer(id,name,age,salary,equipment,Double.parseDouble(Data.EMPLOYEES[i][5]));
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(Data.EQUIPMENTS[i]);
                    employees[i]= new Architect(id,name,age,salary,equipment,Double.parseDouble(Data.EMPLOYEES[i][5]), Integer.parseInt(Data.EMPLOYEES[i][6]));
                    break;
            }
        }
    }

    private Equipment createEquipment(String[] equipment)
    {
        Equipment e = null;
        int type = Integer.parseInt(equipment[0]);
        switch (type){
            case Data.PC:
                e = new PC(equipment[1],equipment[2]);
                break;
            case Data.NOTEBOOK:
                e = new NoteBook(equipment[1],Double.parseDouble(equipment[2]));
                break;
            case Data.PRINTER:
                e = new Printer(equipment[1],equipment[2]);
                break;
        }
        return e;
    }

    public Employee[] getAllEmployees()
    {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException
    {
        for (Employee employee : employees)
        {
            if (employee.getId() == id)
            {
                return employee;
            }
        }
        throw new TeamException("no such employee");
    }
    @Test
    public void test(){
        Employee[] employees = getAllEmployees();
        for (Employee employee : employees)
        {
            System.out.println(employee);
        }
    }
    @Test
    public void test2()
    {
        try
        {
            Employee employee = getEmployee(5);
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
