import java.util.Arrays;

public class P77
{
    public static void main(String[] args)
    {
        int[] counts = new int[10];
        for (int i = 0; i < 100; i++)
        {
            int num = Helper.getRandomNumber(0,9);
            counts[num]++;
        }
        System.out.println(Arrays.toString(counts));
    }


}
