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
public class PC implements Equipment
{
    private String model;
    private String display;

    public PC(String model, String display)
    {
        this.model = model;
        this.display = display;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }

    @Override
    public String getDescription()
    {
        return "PC: { Model: " + model + " , Display: " + display + " }";
    }
}
