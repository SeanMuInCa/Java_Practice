package Project.view;

import java.util.Scanner;

/**
 * Purpose:             Project.view<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    Project.view<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.view <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TSUtility
{
    private static Scanner scanner = new Scanner(System.in);

    /**
     * user's select between numbers
     * @return
     */
    public static char readMenuSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if(c != '1' && c!= '2' && c!= '3' && c!= '4'){
                System.out.println("wrong input, select again!");
            }else break;
        }
        return c;
    }

    public static void readReturn(){
        System.out.println("press enter to continue...");
        readKeyBoard(100, true);
    }
    public static int readInt(){
        int n;
        while (true){
            String str = readKeyBoard(2,false);
            try
            {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return n;
    }

    public static char readConfirmSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1,false).toLowerCase();
            c = str.charAt(0);
            if(c!= 'y' && c!= 'n'){
                System.out.println("wrong input, select again!");
            }else break;
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn){
        String str = "";
        while (scanner.hasNextLine()){
            str = scanner.nextLine();
            if(str.length() == 0){
                if(blankReturn) return str;
                else continue;
            }
            if(str.length() < 1 || str.length() > limit){
                System.out.println("no longer than " + limit + " , input again: ");
                continue;
            }
            break;
        }
        return str;
    }
}
