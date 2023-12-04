
import java.util.Scanner;

public class P73
{
    public static void main(String[] args)
    {
        final int MAX = 10;
        int[] nums = new int[MAX];
//        Arrays.fill(nums,-1);
        System.out.print("Enter the integers between 1 and 100: ");
        getNumbers(nums);
        int[] newArr = cutArr(nums);
        int[] result = new int[newArr.length * 2];
        result = counts(newArr,result);
        result = cutArr(result);
//        System.out.println(Arrays.toString(result));
        print(result);
    }

    private static void print(int[] result)
    {
        for (int i = 0; i < result.length -1; i+=2)
        {
            if(result[i] != 0){
                System.out.println(result[i] + " occurs " + result[i+1]+ " times!");
            }
        }
    }

    private static int[] counts(int[] newArr, int[] result)
    {
        for (int i = 0; i < newArr.length; i++)
        {
            if(!contains(result, newArr[i])){//如果不包含，就在数组里建一个，并把下一个位置++
                result[i*2] = newArr[i];
                result[i*2+1]++;
            }else {
                int index = indexOf(result, newArr[i]);
                result[index+1]++;
            }
        }
        return result;
    }

    /**
     * 判断数组里是否有某个元素
     * @param arr 数组int
     * @param num 值int
     * @return boolean
     */
    public static boolean contains(int[] arr, int num){
        for (int j : arr)
        {
            if (num == j) return true;
        }
        return false;
    }

    /**
     * 包含的情况下，index是多少
     * @param arr 数组
     * @param num 值int
     * @return int
     */
    public static int indexOf(int[] arr, int num){
        for (int i = 0; i < arr.length; i++)
        {
            if(num == arr[i]) return i;
        }
        return -1;
    }

    /**
     * 从尾部切断数组，保留非0的部分
     * @param nums 数组
     * @return 返回一个新数组
     */
    private static int[] cutArr(int[] nums)
    {
        int length = nums.length;
        for (int i = nums.length - 1; i > 0;  i--)
        {
            if(nums[i] == 0){
                length--;
            }else break;
        }
        int[] newArr = new int[length];
        System.arraycopy(nums,0,newArr,0,length);
        return newArr;
    }

    /**
     * 初始化数组
     * @param nums 数组
     */
    private static void getNumbers(int[] nums)
    {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        do {
            nums[i] = scanner.nextInt();
            if(nums[i] == 0) break;
            i++;
        }while (true);

    }


}
