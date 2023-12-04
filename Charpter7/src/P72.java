import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class P72
{
    public static void main(String[] args)
    {
        System.out.print("Enter 10 numbers: ");
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++)
        {
            numbers[i] = scanner.nextInt();
        }
        reverse(numbers);
    }

    private static void reverse(int[] numbers)
    {
        for (int i = 0, j= numbers.length - 1; i < numbers.length / 2; i++, j--)
        {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        System.out.println(Arrays.toString(numbers));
    }

}
