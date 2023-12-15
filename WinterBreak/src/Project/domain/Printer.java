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
public class Printer implements Equipment
{
    private String name;
    private String type;

    public Printer(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String getDescription()
    {
        return "PC: { Name: " + name + " , Type: " + type + " }";
    }
}
