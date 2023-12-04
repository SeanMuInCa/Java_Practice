public class DeckofCards
{
    public static void main(String[] args)
    {
        int[] deck = new int[52];
        final int NUMBERS = 4;
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (int i = 0; i < deck.length; i++)
        {
            deck[i] = i;
        }

        for (int i = 0; i < deck.length; i++)
        {
            int tempIndex = (int) (Math.random() * deck.length);
            int temp = deck[tempIndex];
            deck[tempIndex] = deck[i];
            deck[i] = temp;
        }

        for (int i = 0; i < NUMBERS; i++)
        {
            System.out.print(suits[deck[i] / 13] + " ");
            System.out.println(cards[deck[i] % 13]);
        }

    }
}
