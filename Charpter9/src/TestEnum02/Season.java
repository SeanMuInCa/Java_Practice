package TestEnum02;

/**
 * Purpose:             自定义枚举类<br />
 * Data Submitted:      2023/12/2 <br />
 * Assignment Number:    TestEnum<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestEnum <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public enum Season implements TestInterface
{
    //枚举里实现接口方法
    SPRING
            {
                @Override
                public void show()
                {
                    System.out.println("SPRING");
                }
            },
    SUMMER
            {
                @Override
                public void show()
                {
                    System.out.println("SUMMER");
                }
            },
    FALL
            {
                @Override
                public void show()
                {
                    System.out.println("FALL");
                }
            },
    WINTER
            {
                @Override
                public void show()
                {
                    System.out.println("WINTER");
                }
            };
}
