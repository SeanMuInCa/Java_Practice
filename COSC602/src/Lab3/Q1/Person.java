package Lab3.Q1;

import java.util.Arrays;
import java.util.List;

public class Person {

    private int age;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;

    // valid province codes:

    //    AB - Alberta
    //    BC - British Columbia
    //    MB - Manitoba
    //    NB - New Brunswick
    //    NL - Newfoundland and Labrador
    //    NS - Nova Scotia
    //    ON - Ontario
    //    PE - Prince Edward Island
    //    QC - Quebec
    //    SK - Saskatchewan
    //    NT - Northwest Territories
    //    NU - Nunavut
    //    YT - Yukon

    // {"AB","BC","MB","NB","NL","NS","ON","PE","QC","SK","NT","NU","YT"}
    public static final String[] provinces = {"AB","BC","MB","NB","NL","NS","ON","PE","QC","SK","NT","NU","YT"};
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return lastName + ", " +firstName;
    }

    public String getAddress() {
        return address + "\n" +
                city + ", " + province;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100)
        {
            try
            {
                throw new IllegalArgumentException("The age is not in reasonable range!");
            }catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        List<String> list = Arrays.asList(provinces);
        try
        {
            if(province.length() != 2)
            {
                throw new IllegalArgumentException("Invalid input");
            } else if (!list.contains(province.toUpperCase()))
            {
                throw new IllegalArgumentException("Not an exist province");
            }
        }catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        this.province = province;
    }
}
