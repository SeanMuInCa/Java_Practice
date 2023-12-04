import java.util.Date;

public class TestCicle
{
    public static void main(String[] args)
    {
        Circle circle1 = new Circle(1);
        Circle circle2 = new Circle(2);
        swap1(circle1, circle2);
        System.out.println("After swap1: circle1 = " +
                circle1.radius + " circle2 = " + circle2.radius);
        swap2(circle1, circle2);
        System.out.println("After swap2: circle1 = " +
                circle1.radius + " circle2 = " + circle2.radius);
        int[] a = {1, 2};
        swap(a[0], a[1]);
        System.out.println("a[0] = " + a[0]
                + " a[1] = " + a[1]);
        swap(a);
        System.out.println("a[0] = " + a[0]
                + " a[1] = " + a[1]);
        T t = new T();
        swap(t);
        System.out.println("e1 = " + t.e1
                + " e2 = " + t.e2);

        T1 t1 = new T1();
        T1 t2 = new T1();
        System.out.println("t1's i = " +
                t1.i + " and j = " + t1.j);
        System.out.println("t2's i = " +
                t2.i + " and j = " + t2.j);

        Date[] date = new Date[10];
//        m1(date);
        System.out.println("@!"+date[0]);
    }
    public static void m1(Date date) {
        date = new Date(2);
    }
    public static void swap(T t) {
        int temp = t.e1;
        t.e1 = t.e2;
        t.e2 = temp;
    }
    public static void swap2(Circle x, Circle y) {
        double temp = x.radius;
        x.radius = y.radius;
        y.radius = temp;
    }
    public static void increment(Cicle c, int times) {
        c.radius++;
        times++;
    }
    public static void swap1(Circle x, Circle y) {
        Circle temp = x;
        x = y;
        y = temp;
    }
    public static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }
    public static void swap(int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }
}
class Circle {
    double radius;
    Circle(double newRadius) {
        radius = newRadius;
    }
}
class T {
    int e1 = 1;
    int e2 = 2;
}

class T1
{
    static int i = 0;
    int j = 0;

    T1()
    {
        i++;
        j = 1;
    }
}