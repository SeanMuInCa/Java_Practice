package Lab2;

public class Gcd2
{
    public static void main(String[] args){

        int a  = gcd(125,2525);
        System.out.println(a);
    }

    private static int gcd(int a, int b)
    {
        return b!=0 ? gcd(b,a % b): a;//a和0的最大公约数是a  因为0可以整除任何数
    }
}
