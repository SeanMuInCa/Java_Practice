//public class Test
//{
//    public static void main(String[] args)
//    {
//        int[] list = {1, 2, 3, 5, 4};
//        for (int i = 0, j = list.length-1; i < list.length/2; i++, j--)
//        {
//            // Swap list[i] with list[j]
//            int temp = list[i];
//            list[i] = list[j];
//            list[j] = temp;
//        }
//        Print.printArray(list);
//    }
//
//}
public class Test {
    public static void main(String[] args) {
        int number = 0;
        int[] numbers = new int[1];
        m(number, numbers);
        System.out.println("number is " + number
                + " and numbers[0] is " + numbers[0]);
    }
    public static void m(int x, int[] y) {
        x = 3;
        y[0] = 3;
    }
}
//public class Test {
//    public static void main(String[] args) {
//        int[] list = {1, 2, 3, 4, 5};
//        list = reverse(list);
//        for (int i = 0; i < list.length; i++)
//            System.out.print(list[i] + " ");
//    }
//    public static int[] reverse(int[] list) {
//        int[] newList = new int[list.length];
//        for (int i = 0; i < list.length; i++)
//            newList[i] = list[list.length - 1 - i];
//        list = newList;
//        return newList;
//    }
//}