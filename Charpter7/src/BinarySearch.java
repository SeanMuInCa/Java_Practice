public class BinarySearch
{
    public static int binarySearch(int[] list, int key)
    {
        int left = 0;
        int right = list.length - 1;

        while (left <= right){//if just one element, then have to be =
            int mid = (right - left) / 2 + left;
            if(key == list[mid]){
                return mid;
            } else if (key > list[mid])
            {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -left -1;
    }
}
