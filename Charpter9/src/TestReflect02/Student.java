package TestReflect02;

/**
 * Purpose:             TestReflect02<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    TestReflect02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
@MyAnnotation(value = "hello")
public class Student extends Person implements MyInterface
{
    private int studentId;
    double height;
    protected double weight;
    public double score;

    @MyAnnotation(value = "public_showInfo")
    public String showInfo()
    {
        return "public i am a student";
    }
    public String showInfo(int a , int b)
    {
        return "overload ---- public i am a student";
    }

    private void work()
    {
        System.out.println("private i find a job");
    }
    void happy(){
        System.out.println("default happy method");
    }
    protected int getStudentId() {
        return this.studentId;
    }

    public Student()
    {
        System.out.println("non-param constructor");
    }
    public Student(double weight,double score){
        this.weight = weight;
        this.score = score;
    }

    private Student(int studentId)
    {
        this.studentId = studentId;
    }
    Student(int studentId,double weight){
        this.studentId = studentId;
        this.weight = weight;
    }
    protected Student(int studentId, double weight, double height){
        this.studentId = studentId;
        this.weight = weight;
        this.height = height;
    }

    @Override
    @MyAnnotation(value = "myMethod")
    public void myMethod()
    {
        System.out.println("重写myMethod");
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentId=" + studentId +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                "} ";
    }
}
