package TestString;

/**
 * Purpose:             TestString<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    TestString<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestString <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 形参和实参，本质上还是两个不同的变量，所以还是要分开看
 */
public class Interview2
{
    public static void stringReplace(String text){
        text = text.replace("j", "i");
    }
    public static void bufferReplace(StringBuffer text){
        text.append("C");
        text = new StringBuffer("Hello");//主要是这里，把形参对应的地址指向了别处，但是原本的实参地址不动
        text.append("World!");
    }

    public static void main(String[] args)
    {
        String textStr = new String("java");
        StringBuffer textBuf = new StringBuffer("java");

        stringReplace(textStr);
        bufferReplace(textBuf);

        System.out.println(textStr + textBuf);
    }
}
