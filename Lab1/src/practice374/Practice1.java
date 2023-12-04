package practice374;
import java.util.Scanner;
public class Practice1
{
    public static void main(String[] args)
    {
//        int distance = 250;
//        int speed = 5;
        int distance, speed;
        System.out.print("distance: ");
        Scanner input = new Scanner(System.in);
        distance = input.nextInt();
        System.out.print("speed: ");
        speed = input.nextInt();
        int hours;
        char abc;
        System.out.print("abc: ");
        abc = input.next().charAt(0);
        System.out.println(abc);
        hours = distance / speed;
        System.out.println("It takes "+hours+" hours to Regina");
    }
}
