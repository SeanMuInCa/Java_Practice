package TestRecursive;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/19 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Bagpack
{
    private int[] weights;
    private boolean[] selects;

    public Bagpack(int[] weights)
    {
        this.weights = weights;
        selects = new boolean[weights.length];
    }
    public void solveBag(int total, int index)
    {
        if(total < 0 || total > 0 && index >= weights.length) return;//无解
        if(total == 0)
        {
            for (int i = 0; i < index; i++)
            {
                if(selects[i] == true){
                    System.out.println(weights[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        selects[index] = true;
        solveBag(total - weights[index], index + 1);
        selects[index] = false;
        solveBag(total, index + 1);
    }
}
