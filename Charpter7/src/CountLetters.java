import java.util.Arrays;

public class CountLetters
{
    public static final int COUNT = 100;

    public static void main(String[] args)
    {
        char[] letters = createArray();

        System.out.println("The lowercase letters are:");
        showLetters(letters);
        int[] counter = new int[26];
        counter = countLetters(letters, counter);
//        System.out.println(Arrays.toString(counter));
        System.out.println("The counts are:");
        showCounters(counter);
    }

    private static void showCounters(int[] counter)
    {
        for (int i = 0; i < counter.length; i++)
        {
            if ((i + 1) % 10 == 0)
                System.out.println(counter[i] + " " + (char) (i + 'a'));
            else
                System.out.print(counter[i] + " " + (char) (i + 'a') + " ");
        }
    }

    private static int[] countLetters(char[] letters, int[] counter)
    {
        for (int i = 0; i < letters.length; i++)
        {
            counter[letters[i] - 'a']++;//该字母加1
        }
        return counter;
    }

    private static void showLetters(char[] letters)
    {
        for (int i = 0; i < letters.length; i++)
        {
            if ((i + 1) % 20 == 0)
            {
                System.out.println();
            } else
            {
                System.out.print(letters[i] + " ");
            }
        }
    }

    private static char[] createArray()
    {
        char[] chars = new char[COUNT];
        for (int i = 0; i < chars.length; i++)
        {
            chars[i] = RandomCharacter.getRandomLetterInLowercase();
        }
        return chars;
    }
}
