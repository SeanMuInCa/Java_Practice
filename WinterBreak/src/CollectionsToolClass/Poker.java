package CollectionsToolClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Purpose:             CollectionsToolClass<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    CollectionsToolClass<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          CollectionsToolClass <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Poker
{
    static String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suit = {"♠", "♥", "♣", "♦"};

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < suit.length; i++)
        {
            for (int j = 0; j < num.length; j++)
            {
                list.add(suit[i] + num[j]);
            }
        }
        list.add("Joker1");
        list.add("Joker2");
        Collections.shuffle(list);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> left = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (i < list.size() - 3)
            {
                int index = i % 3;
                switch (index)
                {
                    case 0:
                        player1.add(list.get(i));
                        break;
                    case 1:
                        player2.add(list.get(i));
                        break;
                    case 2:
                        player3.add(list.get(i));
                        break;
                }
            } else
            {
                left.add(list.get(i));
            }

        }
//        Collections.sort(player1, new Comparator<String>(){
//
//
//            @Override
//            public int compare(String o1, String o2)
//            {
//                if(!o1.startsWith("Joker") && !o2.startsWith("Joker")){
//                    return o1.substring(1).compareTo(o2.substring(1));
//                }else if(o1.startsWith("Joker") && !o2.startsWith("Joker")){
//                    return 1;
//                }else if(!o1.startsWith("Joker") && o2.startsWith("Joker")){
//                    return -1;
//                }else{
//                    return o1.substring(5).compareTo(o2.substring(5));
//                }
//            }
//        });
        Comparator pokerComparator = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                int value1 = 0, value2 = 0;
                if (!o1.startsWith("Joker") && !o2.startsWith("Joker"))
                {
                    if (o1.substring(1).equals("J"))
                    {
                        value1 = 11;
                    } else if (o1.substring(1).equals("Q"))
                    {
                        value1 = 12;
                    } else if (o1.substring(1).equals("K"))
                    {
                        value1 = 13;
                    }else if (o1.substring(1).equals("A"))
                    {
                        value1 = 14;
                    }else if (o1.substring(1).equals("2"))
                    {
                        value1 = 15;
                    }else{
                        value1 = Integer.parseInt(o1.substring(1));
                    }

                    if (o2.substring(1).equals("J"))
                    {
                        value2 = 11;
                    } else if (o2.substring(1).equals("Q"))
                    {
                        value2 = 12;
                    } else if (o2.substring(1).equals("K"))
                    {
                        value2 = 13;
                    }else if (o2.substring(1).equals("A"))
                    {
                        value2 = 14;
                    }else if (o2.substring(1).equals("2"))
                    {
                        value2 = 15;
                    }else{
                        value2 = Integer.parseInt(o2.substring(1));
                    }
                    return value1 - value2;
                } else if (o1.startsWith("Joker") && !o2.startsWith("Joker"))
                {
                    return 1;
                } else if (!o1.startsWith("Joker") && o2.startsWith("Joker"))
                {
                    return -1;
                } else
                {
                    return o1.substring(5).compareTo(o2.substring(5));
                }
            }
        };
        Collections.sort(player1, pokerComparator);
        Collections.sort(player2, pokerComparator);
        Collections.sort(player3, pokerComparator);
        Collections.sort(left, pokerComparator);
        System.out.println("player1: " + player1);
        System.out.println("player2: " + player2);
        System.out.println("player3: " + player3);
        System.out.println("left: " + left);
    }
}
