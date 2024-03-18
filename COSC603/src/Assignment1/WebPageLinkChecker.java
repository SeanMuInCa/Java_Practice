package Assignment1;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose:             Assignment1<br />
 * Data Submitted:      2024/3/18 <br />
 * Assignment Number:    Assignment1<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          Assignment1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class WebPageLinkChecker
{
    public static void main(String[] args)
    {
        boolean flag;
        String urlString;
        do
        {
            System.out.print("Enter a url: ");

            urlString = new Scanner(System.in).nextLine();
            flag = urlString.startsWith("http");
        }while (!flag);
        crawler(urlString);
    }
    /**
     * traverse the web from the starting url
     * @param startingURL string of a url
     */
    private static void crawler(String startingURL)
    {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();//visited urls
        ArrayList<String> listOfExceptions = new ArrayList<>();//exceptions

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100)
        {
            String urlString = listOfPendingURLs.remove(0);
            if(!listOfTraversedURLs.contains(urlString))
            {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);
//                System.out.println(getSubURLs(urlString));
                ArrayList<String> subURLs = getSubURLs(urlString);
                for (String s : subURLs)
                {
                    if(s.contains("Exception"))
                    {
                        listOfExceptions.add(s);

                    }
                    if(!listOfTraversedURLs.contains(s))
                    {
                        listOfPendingURLs.add(s);
                    }
                }

            }
        }
        handleOutput(listOfExceptions);
    }

    private static void handleOutput(ArrayList<String> listOfExceptions)
    {
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("deadLinks.txt"));
                )
        {
            listOfExceptions.forEach(s ->
            {
                try
                {
                    s = s.replace("IOException: ","");
                    dos.writeBytes(s + "\n");
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });
        }catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<String> getSubURLs(String urlString)
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        try
        {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int cur = 0;
            while (input.hasNext())
            {
                String line = input.nextLine();
                cur = line.indexOf("http", cur);
                while (cur > 0)
                {
                    int endIndex = line.indexOf("\"", cur);
                    if(endIndex > 0)
                    {
                        list.add(line.substring(cur,endIndex));
                        cur = line.indexOf("http", endIndex);
                    }else
                    {
                        cur = -1;
                    }
                }
            }
        }catch (IOException e)
        {
            list1.add("IOException: " + e.getMessage());
        }
        list.addAll(list1);
        return list;
    }
}
