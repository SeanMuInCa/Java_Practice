package TestReflect02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Purpose:             TestReflect02<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    TestReflect02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    String value();//这是属性，神奇不
}
