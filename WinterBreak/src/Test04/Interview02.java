package Test04;

/**
 * Purpose:             Test04<br />
 * Data Submitted:      2023/12/8 <br />
 * Assignment Number:    Test04<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test04 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Interview02
{
    public static void main(String[] args)
    {
        Father f = new Father();
        Son s = new Son();
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
        System.out.println("-------------");
        s.setInfo("monster");
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
    }
}
class Father{
    private String info = "rainaba";

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }
}

class Son extends Father{
    private String info = "raina";
    public void test(){
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
}