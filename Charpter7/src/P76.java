import java.util.Arrays;

public class P76
{
    public static void main(String[] args)
    {
        final int MAX = 50;
        int[] primes = new int[MAX];
        int start = 2;
        int index = 0;
        while (index < MAX){
            if(Helper.isPrime(start)){
                primes[index]= start;
                index++;
            }
            start++;
        }
        System.out.println(Arrays.toString(primes));
    }
}
