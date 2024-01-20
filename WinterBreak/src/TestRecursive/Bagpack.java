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

/**
 * 问题如下所示：
 *
 * 背包问题也是计算机中的经典问题。在最简单的形式中，包括试图将不同重量的数据项放到背包中，以使得背包最后达到指定的总重量。
 *
 *
 * 示例 :
 *
 * 比如：假设想要让背包精确地承重20磅，
 * 并且有 5 个可以放入的数据项，它们的重量分别是 11 磅，8 磅，7 磅，6 磅，5 磅。
 * 这个问题可能对于人类来说很简单，我们大概就可以计算出 8 磅+ 7 磅 + 5 磅 = 20 磅。
 * 但是如果让计算机来解决这个问题，就需要给计算机设定详细的指令了。
 *
 *
 * 问题分析
 *
 * 一、如果在这个过程的任何时刻，选择的数据项的总和符合目标重量，那么工作便完成了。
 * 二、从选择的第一个数据项开始，剩余的数据项的加和必须符合背包的目标重量减去第一个数据项的重量，这是一个新的目标重量。
 * 三、逐个的试每种剩余数据项组合的可能性，但是注意不要去试所有的组合，因为只要数据项的和大于目标重量的时候，就停止添加数据。
 * 四、如果没有合适的组合，放弃第一个数据项，并且从第二个数据项开始再重复一遍整个过程。
 * 五、继续从第三个数据项开始，如此下去直到你已经试验了所有的组合，这时才知道有没有解决方案。
 *
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
    public static void main(String[] args) {
        int array[] = {11,9,7,6,5};
        int total = 20;
        Bagpack k = new Bagpack(array);
        k.solveBag(total, 0);
    }
}
