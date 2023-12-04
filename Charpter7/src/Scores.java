import java.util.Arrays;
import java.util.Scanner;


public class Scores
{
    public static void main(String[] args)
    {
        System.out.print("Enter the number of students: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int[] scores = new int[number];
        System.out.print("Enter the scores: ");
        for (int i = 0; i < number; i++)
        {
            scores[i] = scan.nextInt();
        }
        int max = getMax(scores);
        printScore(max,scores);
    }

    private static void printScore(int max, int[] scores)
    {
        for (int i = 0; i < scores.length; i++)
        {
            System.out.println("Student "+ i + " score is "+ scores[i] + " and grade is " + printGrade(scores[i], max));
        }
    }

    private static char printGrade(int score, int max)
    {
        if(score >= max - 10){
            return 'A';
        }else if (score >= max - 20){
            return 'B';
        }else if (score >= max - 30){
            return 'C';
        }else if (score >= max - 40){
            return 'D';
        }else{
            return 'F';
        }
    }

    private static int getMax(int[] scores)
    {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++)
        {
            if(scores[i] > max){
                max = scores[i];
            }
        }
        return max;
    }
}
