package TestString;

import java.util.Scanner;

/**
 * Purpose:             TestString<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    TestString<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestString <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Login
{
    public static void main(String[] args)
    {
        User[] users = new User[7];
        users[0] = new User("abc", "123");
        users[1] = new User("abcd", "123");
        users[2] = new User("abcde", "123");
        users[3] = new User("abcdef", "123");
        users[4] = new User("abcdefg", "123");
        users[5] = new User("bcd", "123");
        users[6] = new User("def", "123");

        Scanner sc = new Scanner(System.in);
        System.out.println("input username: ");
        String name = sc.next();
        System.out.println("input password: ");
        String password = sc.next();
        int i;
        for (i = 0; i < users.length; i++)
        {
            if(users[i].getName().equals(name)){
                if(users[i].getPassword().equals(password)){
                    System.out.println("login success: " + users[i]);
                }else{
                    System.out.println("password error");
                }
                break;
            }
        }
        if(i == users.length){
            System.out.println("no record");
        }
    }

}
class User{
    private String name;
    private String password;

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString()
    {
        return name + " - " + password;
    }
}
