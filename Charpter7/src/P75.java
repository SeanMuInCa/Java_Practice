import java.util.Arrays;
import java.util.Scanner;
public class P75
{
    public static void main(String[] args)
    {
        final int MAX = 10;
        System.out.print("Enter 10 numbers: ");
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[MAX];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = scanner.nextInt();
        }

        int[] result = checkDistinct(numbers);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }

    private static int[] checkDistinct(int[] numbers)
    {
        int[] temp = new int[numbers.length];
        int index = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if(!Helper.contains(temp, numbers[i])){
                temp[index] = numbers[i];
                index++;
            }
        }

        return Helper.cutArr(temp);
    }
}
