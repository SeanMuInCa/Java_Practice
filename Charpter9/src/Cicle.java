public class Cicle
{
    public double radius = 1;
    private static int numberOfInstances = 0;
    Cicle(){
        numberOfInstances++;
    }
    Cicle(double newRadius) {
        radius = newRadius;
        numberOfInstances++;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double newRadius){
        radius = newRadius >= 0 ? newRadius : 0;
    }
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
    public static int getNumberOfInstances() {
        return numberOfInstances;
    }
}
