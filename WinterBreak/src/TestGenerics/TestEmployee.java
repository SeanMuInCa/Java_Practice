package TestGenerics;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2023/12/22 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestEmployee
{
    public static void main(String[] args)
    {
        Comparator<Employee> comparator = new Comparator<Employee>()
        {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                if(o1.getBirthday().getYear() == o2.getBirthday().getYear()){
                    if(o1.getBirthday().getMonth() == o2.getBirthday().getMonth()){
                        return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                    }else{
                        return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                    }
                }else{
                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                }
            }
        };
        TreeSet<Employee> set = new TreeSet<>(comparator);
        Employee e1 = new Employee("b", 23, new MyDate(2000, 1, 1));
        Employee e2 = new Employee("li", 22, new MyDate(2001, 4, 20));
        Employee e3 = new Employee("wang", 33, new MyDate(1990, 1, 1));
        Employee e4 = new Employee("a", 24, new MyDate(1999, 5, 1));
        Employee e5 = new Employee("zhou", 33, new MyDate(1990, 3, 1));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
