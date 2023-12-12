package Test06;

public class GF
{
    //1.构造器私有化
    private GF()
    {

    }
    //2. 声明一个实例
    private static GF gf = null;

    //3.通过静态方法获取实例，如果没有创建，就创建
    public static GF getInstance()
    {
        if(gf == null)
            gf = new GF();
        return gf;
    }
}
