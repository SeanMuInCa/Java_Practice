import java.util.Arrays;

/**
 * Purpose:             <br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:           <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] array1 = {3, 1, 4, 1}; // 用于排序的数组
        String[] array2 = {"C", "A", "D", "B"}; // 需要根据array1排序的数组

        // 创建一个包含数组下标的数组，并根据array1数组的数值大小对其进行排序
        int[] indexes = new int[array1.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        // 对indexes数组根据array1的数值大小进行冒泡排序（这里使用了冒泡排序作为演示，也可以使用其他排序算法）
        for (int i = 0; i < array1.length - 1; i++) {
            for (int j = 0; j < array1.length - i - 1; j++) {
                if (array1[indexes[j]] > array1[indexes[j + 1]]) {
                    int temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
            }
        }

        // 根据排序后的indexes数组顺序重新排列array2数组
        String[] sortedArray2 = new String[array2.length];
        for (int i = 0; i < indexes.length; i++) {
            sortedArray2[i] = array2[indexes[i]];
        }


        // 输出排序后的array2数组
        System.out.println(Arrays.toString(sortedArray2));
    }
}