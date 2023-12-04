package assign1;

/**
 * Purpose:             To calculate the surface area of a pyramid  <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q1.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q1
{

    public static void main(String[] args)
    {
        //declare variables such as base length, side height and surface area
        float baseLength = 75.3F,
                sideHeight = 41.74F;
        float surfaceArea;

        //calculate the area
        surfaceArea = 2 * baseLength * sideHeight + baseLength * baseLength;

        // convert the result in an explicit way to 2 decimal
        surfaceArea = (float) ((int) (surfaceArea * 100)) / 100;

        //display result
        System.out.println("The surface area is : " + surfaceArea);
    }
}
