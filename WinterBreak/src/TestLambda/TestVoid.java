package TestLambda;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/1/10 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestVoid
{
    public static void main(String[] args)
    {
        //void 无参数形式函数接口修改Lambda表达式
        callSomething(new Call()
        {
            @Override
            public void shout()
            {
                System.out.println("hello,world");
            }
        });
        callSomething(() -> System.out.println("hello"));
        callSomething(() -> System.out.println("world"));
    }
    public static void callSomething(Call call){
        call.shout();
    }
}
interface Call
{
    void shout();
}