package TestGenerics;

import java.util.Date;
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
 * DAO:data access object,内部封装了操作数据库相关表的增删改查操作（CRUD）
 * 查不同的表的时候，数据类型没办法确定，所以使用泛型
 * 数据库中的一个表，与 java中的一个类对应
 * 表中的一条记录，就与java中的一个对象对应
 * 表中的一个字段，就与java类中的一个属性对应
 */
public class DAO<T>
{
    public void insert(T t)
    {
        System.out.println("insert");
    }
    public T delete(int id){
        System.out.println("delete");
        return null;
    }
    public void update(int id, T t){
        System.out.println("update");
    }
    public T getInfo(int id){
        System.out.println("getInfo");
        return null;
    }
    public List<T> getAll(){
        System.out.println("getAll");
        return null;
    }
}
/*
* ORM(object relational mapping)这里就假设有个用户表
* 数据库中的一个表，与 java中的一个类对应
* 表中的一条记录，就与java中的一个对象对应
* 表中的一个字段，就与java类中的一个属性对应
* */
class Customer{
    int id;
    String name;
    String email;
    Date birth;
}
class CustomerDAO extends DAO<Customer>{//针对这个表的
}
class Test{
    @org.junit.Test
    public void test(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insert(new Customer());//这里就只能操作customer了
    }
}
class Order{//这里也对应一个表
    int orderId;
    String orderName;
    Date orderDate;
}
