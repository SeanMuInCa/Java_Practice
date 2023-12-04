public class Override
{
    public static void main(String[] args){
        double a = getDouble(4,6);
        double b = getDouble(4,6.5);
        double c = getDouble(4.5,6.5);
    }
    public static double getDouble(double x, double y){
        System.out.println("d d called");
        return 0;
    }
    public static double getDouble(int x, double y){
        System.out.println("i d called");
        return 0;
    }
}
