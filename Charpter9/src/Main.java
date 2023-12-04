import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    private int a = 11213;
    public static void main(String[] args) throws FileNotFoundException
    {
        /*Random generator1 = new Random(500);
        System.out.print("From generator1: ");
        for (int i = 0; i < 10; i++)
            System.out.print(generator1.nextInt(1000) + " ");
        Random generator2 = new Random(1);
        System.out.print("\nFrom generator2: ");
        for (int i = 0; i < 10; i++)
            System.out.print(generator2.nextInt(100) + " ");
        Main m = new Main();
        System.out.println(m.a);
        System.out.println(Helper.a);
        System.out.println(Helper.b);
//        System.out.println(Helper.c);*/
        /*Student stu1 = new Student("Raina", 13, "female",1001);
        Student stu2 = new Student("Raina", 13, "female",1001);
        System.out.println(stu1.getAge() +" "+ stu1.getNumber());
        System.out.println(stu1);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        Calendar cal = new GregorianCalendar();
        System.out.println(cal);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());*/
        java.io.File file = new java.io.File("src/123.txt");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
         System.out.println("Is it absolute? " + file.isAbsolute());
         System.out.println("Is it hidden? " + file.isHidden());
         System.out.println("Absolute path is " + file.getAbsolutePath());
         System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
//        try(PrintWriter output = new PrintWriter("src/1232.txt");)
//        {
//            output.print("John T Smith ");
//            output.println(90);
//            output.print("Eric K Jones ");
//            output.println(85);
////            output.close();
//        } catch (FileNotFoundException e)
//        {
//            throw new RuntimeException(e);
//        }
        java.io.File file1 = new java.io.File("src/1232.txt");
        Scanner input = new Scanner(file1);
        while (input.hasNext()) {
            String firstName = input.next();
             String mi = input.next();
             String lastName = input.next();
             int score = input.nextInt();
             System.out.println( firstName + " " + mi + " " + lastName + " " + score);
             }
        }
    }

