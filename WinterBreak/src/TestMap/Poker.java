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
        Map<Integer, String> poker = new HashMap<>();
        int count = 1;

        for (String number : numbers)
        {
            for (String sign : signs)
            {
                poker.put(count, sign + number);
                count++;
            }

        }

        poker.put(count++, "🃏");
        poker.put(count++, "🃏");
        System.out.println(poker);

        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> fold = new ArrayList<>();
        Set<Integer> set = poker.keySet();
        List<Object> list = Arrays.asList(set.toArray());
        Collections.shuffle(list);

        System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 50)
            {
                fold.add((Integer) list.get(i));
            } else
            {
                int temp = i % 3;
                switch (temp)
                {
                    case 0 -> player1.add((Integer) list.get(i));
                    case 1 -> player2.add((Integer) list.get(i));
                    case 2 -> player3.add((Integer) list.get(i));
                }
            }

        }
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(fold);

        System.out.print("player1: ");
        player1.forEach(i -> System.out.print(poker.get(i) + " "));
        System.out.println();
        System.out.print("player2: ");
        player2.forEach(i -> System.out.print(poker.get(i) + " "));
        System.out.println();
        System.out.print("player3: ");
        player3.forEach(i -> System.out.print(poker.get(i) + " "));
        System.out.println();
        System.out.print("fold: ");
        fold.forEach(i -> System.out.print(poker.get(i) + " "));
    }
}
