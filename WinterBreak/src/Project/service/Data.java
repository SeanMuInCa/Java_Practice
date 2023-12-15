package Project.service;

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
public class Data
{
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PRINTER = 23;
    public static final int NOTEBOOK = 22;
    public static final int PC = 21;

    public static final String[][] EMPLOYEES = {
            {"10", "1","John Doe", "23", "5000"},
            {"11", "2","Jane Doe", "23", "5000"},
            {"12", "3","Jimi Doe", "23", "5000","1500"},
            {"13", "4","Joey Doe", "23", "5000","1500","2500"},
    };

    public static final String[][] EQUIPMENTS = {
            {},
            {"21","HP Pavilion", "SAMSUNG27'" },
            {"22","Macbook Pro", "15000" },
            {"23","Canon", "EOS 70D" },
    };
}
