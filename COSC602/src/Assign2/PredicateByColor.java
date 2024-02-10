package Assign2;

import java.util.function.Predicate;

/**
 * Purpose:             Assign2<br />
 * Data Submitted:      2024/2/9 <br />
 * Assignment Number:    Assign2<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Assign2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class PredicateByColor implements Predicate<Apple>
{
    private String color;

    public PredicateByColor(String color)
    {
        this.color = color;
    }

    @Override
    public boolean test(Apple apple)
    {
        return this.color.equalsIgnoreCase(apple.getColor());
    }
}
