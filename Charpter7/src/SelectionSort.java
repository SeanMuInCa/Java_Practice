public class SelectionSort
{
    /**
     * The method for sorting the numbers
     */
    public static void selectionSort(double[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            // Find the minimum in the list[i..list.length−1]
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++)//这里只是找最小值，没有操作数组
            {
                if (currentMin > list[j])
                {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary 这里操作数组
            if (currentMinIndex != i)
            {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}