package MyHash;

import java.util.ArrayList;

/**
 * Purpose:             MyHash<br />
 * Data Submitted:      2024/3/16 <br />
 * Assignment Number:    MyHash<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          MyHash <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class SimpleHash
{

    public static void main(String[] args)
    {
        String[] names = new String[]
                {
                        "abc", "def", "xyz", "jackson", "Ohnio", "jordan", "peppon", "robert"
                };
        String[] myHashTable = new String[101];

           /* foreach (String name in names) 
            {
                *//*int hashindex = SimpleHash(myHashTable, name);*//*
                int hashindex = BetterHash(myHashTable, name);
                System.out.println(hashindex + " " + name);
                myHashTable[hashindex] = name;
            }
            int count = 0;
            System.out.println();
            foreach (String name in myHashTable) 
            {
                if (name != null)
                { 
                    System.out.println(count + " " + name);
                    count++;
                }
                
            }*/
        BucketHash bucketHash = new BucketHash();
        for (String name : names)
        {
            bucketHash.Insert(name);
        }
        bucketHash.PrintArray();
        bucketHash.Remove("Ohnio");
        System.out.println("----------------------");
        bucketHash.PrintArray();
    }

    static int SimpleHash(String[] names, String name)
    {
        int total = 0;
        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            total += (int) chars[i];
        }
        return total % names.length;
    }

    static int BetterHash(String[] names, String name)
    {
        long total = 0;
        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            total += 23 * total + (int) chars[i];
        }
        return Math.abs((int) total % names.length);
    }
}

 class BucketHash
{
    private final int SIZE = 101;
    ArrayList[] data;

    public BucketHash()
    {
        data = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            data[i] = new ArrayList<String>();
        }
    }

    public void PrintArray()
    {
        int count = 0;
        for (ArrayList<String> item : data)
        {
            if (!item.isEmpty())
                System.out.println(count + ": ");
            for (String name : item)
            {
                System.out.println(name + " ");
            }
            if (!item.isEmpty())
                System.out.println();
            count++;
        }
    }

    public int Hash(String str)
    {
        long total = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            total += 21 * total + (int) chars[i];
        }
        total = total % data.length;

        return (int) total;
    }

    public void Insert(String item)
    {
        int hash = Hash(item);
        if (!data[hash].contains(item))
        {
            data[hash].add(item);//adding to arraylist first, not directly to hashtable
        }
    }

    public void Remove(String item)
    {
        int hash = Hash(item);
        data[hash].remove(item);
    }
}

