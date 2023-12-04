package Lab2;

public class LoopTest
{
    public static void main(String[] args)
    {
        System.out.println("\t\tMultiplication Table");
        for (int i = 1; i < 10; i++)
        {
            System.out.print("\t\t\t" + i);
        }
        System.out.println("");
        System.out.print("-----------------------------------------------------------------------------------------------------------------\n");
        for (int j = 1; j <= 9; j++)
        {
            System.out.print(j + " | ");
            for (int k = 1; k <= 9; k++)
            {
                System.out.print("\t\t" + (j * k) + "\t");
            }
            System.out.println("");
        }
    }
}
