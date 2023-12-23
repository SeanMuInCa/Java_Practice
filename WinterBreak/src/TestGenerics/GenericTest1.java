package TestGenerics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
 * ?的使用
 */
public class GenericTest1
{
    @Test
    public void test(){
        List<?> list = null;
        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        list = list1;
        list = list2;
//        list1 = list2;报错
//        list2 = list1;报错
        method(list);
        method(list1);
        method(list2);
    }
    public void method(List<?> list){

    }

    @Test
    public void test2(){
        List<?> list = null;
        List<String> list1 = new ArrayList<>();
        list1.add("AA");

        list = list1;
        //read
        Object o = list.get(0);
        if(o instanceof String){
            String s = (String) o;
            System.out.println(s);
        }

        //write
//        list.add("a");不行，通配符？的集合，不能写入，除了null
    }
    //有条件的通配符? extends A和 ? super B
    @Test
    public void test3(){
        List<? extends Father> list = new ArrayList<>();//只能继承于Father的类和father
        List<Object> list1 = new ArrayList<>();
        List<Father> list2 = new ArrayList<>();
        List<Son> list3 = new ArrayList<>();

//        list = list1;不行
        list = list2;
        list = list3;
    }
    @Test
    public void test4(){
        List<? super Father> list = new ArrayList<>();//只能是比father大的类才行
        List<Object> list1 = new ArrayList<>();
        List<Father> list2 = new ArrayList<>();
        List<Son> list3 = new ArrayList<>();

        list = list1;
        list = list2;
//        list = list3;不行
    }
}
class Father{}
class Son extends Father{}