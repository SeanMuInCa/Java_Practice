package TestGenerics;

import org.junit.Test;

import java.util.*;

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
public class Exe1
{
    @Test
    public void test(){
        User u1 = new User(14, "zhenghua", 1);
        User u2 = new User(13, "raina", 2);
        User u3 = new User(15, "rainma", 3);
        DAO1<User> dao1 = new DAO1<>();
        dao1.save("1", u1);
        dao1.save("2", u2);
        dao1.save("3", u3);
        System.out.println(dao1.map);
//        System.out.println(dao1);
        dao1.delete("1");
        System.out.println(dao1.map);
    }
}
class User{
    private int age;
    private String name;
    private int id;

    public User(int age, String name, int id)
    {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(age, name, id);
    }
}
class DAO1<T>{
    Map<String, T> map = new HashMap<>();
    public void save(String id, T entity){
        if(!map.containsKey(id)){
            map.put(id, entity);
        }
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }
    public List<T> list(){
        Collection<T> values = map.values();
        return new ArrayList<>(values);
    }
    public void delete(String id){
        map.remove(id);
    }
}
