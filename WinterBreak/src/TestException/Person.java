package TestException;

/**
 * Purpose:             TestException<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    TestException<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestException <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Person
{
    private int lifeValue;
    private String name;

    public Person()
    {
    }

    public Person(int lifeValue, String name)
    {
        setName(name);
        setLifeValue(lifeValue);
    }

    public int getLifeValue()
    {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue)
    {
        if(lifeValue >= 0){
            this.lifeValue = lifeValue;
        }else{
            throw new NoLifeValueException("No life value!");
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "lifeValue=" + lifeValue +
                ", name='" + name + '\'' +
                '}';
    }

    private class NoLifeValueException extends RuntimeException
    {
        public NoLifeValueException()
        {
            super();
        }
        public NoLifeValueException(String msg){
            super(msg);
        }
    }
}
