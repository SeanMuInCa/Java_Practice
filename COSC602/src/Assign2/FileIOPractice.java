package Assign2;

import Assign2.Apple;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileIOPractice{

    public static void main(String[] args) {
        ArrayList<Apple> obList = readFile("Apples.csv");

        for (Apple a : obList)
        {
            System.out.println(a);
        }
        //To-Do use forEach method to print the apples read from the file.

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
            e.printStackTrace();
        }
        return list;
    }
}