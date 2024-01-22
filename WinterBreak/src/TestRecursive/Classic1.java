package TestRecursive;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/22 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Classic1
{
    /**
     * 一个数字三角形。 请编一个程序计算从顶至底的某处的一条路
     * 　　径，使该路径所经过的数字的总和最大。
     * 　　每一步可沿左斜线向下或右斜线向下走；
     * 　　1＜三角形行数≤100；
     * 　　三角形中的数字为整数0，1，…99；
     */
    @Test
    public void test1()
    {
        int[][] map;
        int num = 5;
        map = new int[num][num];
        for (int i = 0; i < num; i++)
        {
            for (int j = 0; j < i; j++)
            {
                map[i][j] = generate(0, 100);
            }
        }
        System.out.println(Arrays.toString(map));
        System.out.println(caculate(num, map, 0, 0));
    }

    private int caculate(int num, int[][] map, int i, int j)
    {
        if (i == num - 2) return map[i][j] + Math.max(map[i + 1][j], map[i + 1][j + 1]);
        return map[i][j] + Math.max(caculate(num, map, i + 1, j), caculate(num, map, i + 1, j + 1));
    }

    private int generate(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max) + min;
    }
}
