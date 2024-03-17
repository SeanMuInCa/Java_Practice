package TestMap;

import java.util.*;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2024/3/17 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Poker
{
    public static void main(String[] args)
    {
        ArrayList<String> signs = new ArrayList<>(Arrays.asList("♦,♥,♠,♣".split(",")));
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("2,3,4,5,6,7,8,9,10,J,Q,K,A".split(",")));
        Map<Integer,String> poker = new HashMap<>();
        int count = 1;
        for (String sign : signs)
        {
            for (String number : numbers)
            {
                poker.put(count,sign+number);
                count++;
            }
        }
        poker.put(count++, "🃏");
        poker.put(count++, "🃏");
        System.out.println(poker);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> fold = new ArrayList<>();
        Set<Integer> set = poker.keySet();
        List<Object> list = Arrays.asList(set.toArray());
        Collections.shuffle(list);

        System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            if(i > 50) {
                fold.add(poker.get(list.get(i)));
            }else {
                int temp = i % 3;
                switch (temp)
                {
                    case 0 -> player1.add(poker.get(list.get(i)));
                    case 1 -> player2.add(poker.get(list.get(i)));
                    case 2 -> player3.add(poker.get(list.get(i)));
                }
            }

        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(fold);
    }
}
