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
        Comparator<String> pokerComparator = new Comparator<>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                int value1 = 0, value2 = 0;
                if (!o1.startsWith("Joker") && !o2.startsWith("Joker"))
                {
                    value1 = switch (o1.substring(1))
                    {
                        case "J" -> 11;
                        case "Q" -> 12;
                        case "K" -> 13;
                        case "A" -> 14;
                        case "2" -> 15;
                        default -> Integer.parseInt(o1.substring(1));
                    };

                    value2 = switch (o2.substring(1))
                    {
                        case "J" -> 11;
                        case "Q" -> 12;
                        case "K" -> 13;
                        case "A" -> 14;
                        case "2" -> 15;
                        default -> Integer.parseInt(o2.substring(1));
                    };
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
        player1.sort(pokerComparator);
        player2.sort(pokerComparator);
        player3.sort(pokerComparator);
        left.sort(pokerComparator);
        System.out.println("player1: " + player1);
        System.out.println("player2: " + player2);
        System.out.println("player3: " + player3);
        System.out.println("left: " + left);
    }
}
