package Lab2;
import java.util.Scanner;
public class Gcd
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("input a number: ");
        int a = in.nextInt();
        System.out.println("input another number: ");
        int b = in.nextInt();
        int gcd = 1;
        int k = 2;
        int max = Math.max(a, b);
//        int min = Math.min(a,b);
        for ( k = 2; k <= max/2 ; k++) {
            if (a % k == 0 && b % k == 0)
                gcd = k;
        }
        System.out.println("The greatest common divisor for " + a +
                " and " + b + " is " + gcd);
    }
}
