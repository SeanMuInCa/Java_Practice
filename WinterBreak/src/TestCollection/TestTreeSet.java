package TestCollection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * treeset添加元素的时候，如果比较条件是相等，那么就不允许添加多个
 */
public class TestTreeSet
{
    @Test
    public void test(){//treeset是基于红黑树，因此要比较大小，所以只能是同一个类型，如果要加对象，需要comparable
        TreeSet<Integer> set = new TreeSet<>();
        set.add(23);
        set.add(12);
        set.add(123);
//        set.add(new Person("raina",14));
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test2(){
        TreeSet set = new TreeSet<>();
        Student s1 = new Student("raina1",14);
        Student s2 = new Student("raina2",12);
        Student s3 = new Student("raina3",15);
        Student s4 = new Student("raina4",14);
        Student s5 = new Student("raina5",117);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test3(){
        TreeSet set = new TreeSet<>(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2)
            {
                return o1.getAge() - o2.getAge();//此时，只有4个了，因为有2个年龄一样
            }
        });
        Student s1 = new Student("raina1",14);
        Student s2 = new Student("raina2",12);
        Student s3 = new Student("raina3",15);
        Student s4 = new Student("raina4",14);
        Student s5 = new Student("raina5",117);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
