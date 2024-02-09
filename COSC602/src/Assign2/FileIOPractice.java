package Assign2;


import java.io.*;
import java.util.*;

public class FileIOPractice{

    public static void main(String[] args) {
        ArrayList<Apple> obList = readFile("Apples.csv");

        for (Apple a : obList)
        {
            System.out.println(a);
        }
        System.out.println();
        System.out.println(Arrays.toString(findUniqueAppleNames(obList)));
    }

    public static String[] findUniqueAppleNames (ArrayList<Apple> obList)
    {
        Set<String> set = new HashSet<>();
        for (Apple a : obList)
        {
            set.add(a.getName());
        }
        String[] arr = new String[set.size()];
        Iterator<String> it = set.iterator();
        int index = 0;
        while (it.hasNext())
        {
            arr[index++] = it.next();
        }
        return arr;
    }
    public static ArrayList<Apple> readFile(String sName)
    {
        ArrayList<Apple> list = new ArrayList<>();
        try
        {
            BufferedReader bis = new BufferedReader(new FileReader(new File(sName)));
            String oneLineData;
            bis.readLine();
            while ((oneLineData = bis.readLine()) != null)
            {

                String[] result = oneLineData.split(",");
                Apple apple = new Apple(Integer.parseInt(result[0]),result[1],result[2],Double.parseDouble(result[3]),Double.parseDouble(result[4]));
                list.add(apple);
            }

        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
}