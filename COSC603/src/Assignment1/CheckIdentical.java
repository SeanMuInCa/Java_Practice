package Assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Purpose:             Assignment1<br />
 * Data Submitted:      2024/3/13 <br />
 * Assignment Number:    Assignment1<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          Assignment1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CheckIdentical
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a name for file1: ");
        String name1 = input.nextLine();
        System.out.print("Input a name for file2: ");
        String name2 = input.nextLine();
        checkIdentical(name1, name2);
    }

    private static void checkIdentical(String name1, String name2)
    {
        try(
                FileInputStream fis1 = new FileInputStream(name1);
                FileInputStream fis2 = new FileInputStream(name2);
                )
        {

            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
                if (byte1 != byte2) {
                    System.out.println("Not identical!");
                    return;
                }
            }
            if(fis1.readAllBytes().length != fis2.readAllBytes().length)
            {
                System.out.println("Not identical!");
                return;
            }
            System.out.println("Identical!");
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
