//import RandomCh
public class TestRandom
{
    public static void main(String[] args)
    {
        final int NUMBERS_OF_CHARS = 125;
        final int CHARS_PER_LINE = 25;
        for (int i = 0; i < NUMBERS_OF_CHARS; i++)
        {
            char c = RandomCharacter.getRandomLetterInLowercase();
            if ((i + 1) % CHARS_PER_LINE == 0)
            {
                System.out.println(c);
            } else
            {
                System.out.print(c);
            }
        }
    }
}
