package TestEnum;

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
public class Season
{
    private final String seasonName;
    private final String seasonDescription;

    //季节是有限的，因此不能让外部直接调用构造器进行赋值，否则会瞎赋值，私有化构造器就不允许外界访问
    //只能内部处理构造器。为了防止赋值出错，用枚举来处理
    private Season(String seasonName, String seasonDescription)
    {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }

    //枚举的基本形态
    public static final Season spring = new Season("spring","good weather");
    public static final Season summer = new Season("summer","hot weather");
    public static final Season fall = new Season("fall","refresh weather");
    public static final Season winter = new Season("winter","cold weather");

    public String getSeasonName()
    {
        return seasonName;
    }

    public String getSeasonDescription()
    {
        return seasonDescription;
    }

    @Override
    public String toString()
    {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescription='" + seasonDescription + '\'' +
                '}';
    }
}
