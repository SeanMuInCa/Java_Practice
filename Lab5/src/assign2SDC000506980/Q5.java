package assign2SDC000506980;

/**
 * Purpose:             To displays all result of 100,000 times dice rolled <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q5 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q5
{
    public static void main(String[] args)
    {
        //const times
        final int TIMES = 100000;
        //declares results for each result
        int result2 = 0, result3 = 0, result4 = 0, result5 = 0, result6 = 0, result7 = 0, result8 = 0, result9 = 0, result10 = 0, result11 = 0, result12 = 0;
        for (int i = 0; i < TIMES; i++)
        {
            int result = getResultForTowDices();
            switch (result)
            {
                case 2 -> result2++;
                case 3 -> result3++;
                case 4 -> result4++;
                case 5 -> result5++;
                case 6 -> result6++;
                case 7 -> result7++;
                case 8 -> result8++;
                case 9 -> result9++;
                case 10 -> result10++;
                case 11 -> result11++;
                case 12 -> result12++;
            }
        }
        System.out.println("For 100,000 times dices rolled, the result 2 appears " + result2 + " times");
        System.out.println("For 100,000 times dices rolled, the result 3 appears " + result3 + " times");
        System.out.println("For 100,000 times dices rolled, the result 4 appears " + result4 + " times");
        System.out.println("For 100,000 times dices rolled, the result 5 appears " + result5 + " times");
        System.out.println("For 100,000 times dices rolled, the result 6 appears " + result6 + " times");
        System.out.println("For 100,000 times dices rolled, the result 7 appears " + result7 + " times");
        System.out.println("For 100,000 times dices rolled, the result 8 appears " + result8 + " times");
        System.out.println("For 100,000 times dices rolled, the result 9 appears " + result9 + " times");
        System.out.println("For 100,000 times dices rolled, the result 10 appears " + result10 + " times");
        System.out.println("For 100,000 times dices rolled, the result 11 appears " + result11 + " times");
        System.out.println("For 100,000 times dices rolled, the result 12 appears " + result12 + " times");
    }

    /**
     * get result
     * @return int the result of each roll
     */
    public static int getResultForTowDices()
    {
        return getResultInDice() + getResultInDice();
    }

    /**
     * result of single dice
     * @return int result of single roll
     */
    public static int getResultInDice()
    {
        return (int) ((Math.random() * 6) + 1);
    }
}
