public class Testcopy
{
    public static void main(String[] args){
        int[] keys = {1,2,3};
        int[] keys2 = new int[3];
        System.arraycopy(keys, 1,keys2,0,keys2.length-1);
        for (int i = 0; i < keys2.length; i++)
        {
            System.out.println(keys2[i]);
        }
    }
}
