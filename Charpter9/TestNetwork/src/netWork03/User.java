package netWork03;

import java.io.Serial;
import java.io.Serializable;

/**
 * Purpose:             netWork03<br />
 * Data Submitted:      2023/11/30 <br />
 * Assignment Number:    netWork03<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          netWork03 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class User implements Serializable
{
    @Serial
    private static final long serialVersionUID = -4432714657645568692L;
    private String name;
    private String pwd;

    public User(String name, String pwd)
    {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
}
