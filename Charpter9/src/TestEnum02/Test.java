package TestEnum02;

/**
 * Purpose:             TestEnum02<br />
 * Data Submitted:      2023/12/2 <br />
 * Assignment Number:    TestEnum02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestEnum02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test
{
    public static void main(String[] args)
    {
        Season fall = Season.FALL;
        fall.show();
        Season spring = Season.SPRING;
        spring.show();

        //返回一个数组
        Season[] values = Season.values();
        for (Season s : values)
        {
            System.out.println(s);
        }

    }
}
