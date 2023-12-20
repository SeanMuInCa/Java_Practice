package TestCollection;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe2
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("----songs---");
            System.out.println("press 1 to order, " +
                    "press 2 to top," +
                    "press 3 to move forward," +
                    "press 4 to quit: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("input song's name: ");
                String song = sc.next();
                if(!list.contains(song)){
                    list.add(song);
                }else{
                    System.out.println("this song is already in the list");
                }
            }else if(choice == 4){
                break;
            } else if (choice == 2)
            {
                for (int i = 0; i < list.size(); i++)
                {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
                System.out.println("which one ");
                int index = sc.nextInt();
                String s = list.get(index - 1);
                list.remove(index - 1);
                list.add(0, s);

            } else if (choice == 3)
            {
                for (int i = 0; i < list.size(); i++)
                {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
                System.out.println("which one ");
                int index = sc.nextInt();
                String s = list.get(index - 1);
                list.remove(index - 1);
                list.add(index - 2, s);
            }
        }
    }
}
