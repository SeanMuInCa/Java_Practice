package com.example.assignment3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

import java.util.Random;
//import javafx.scene.paint.Color;

public class ControlBox extends HBox{
    private Label a; //Left operand
    private Label o; //Operator
    private Label b; //Right operand
    private TextField c; //Your entered result
    private Label e;  //equal sign
    double width;
    double height;

    public ControlBox()
    {
        a = new Label(" 1 ");
        b = new Label(" 1 ");
        o = new Label(" + ");
        e = new Label(" = ");
        c = new TextField();
        width = 200;
        height = 50;
        this.setAlignment(Pos.CENTER);
        this.setWidth(width);
        this.setHeight(height);
        this.getChildren().add(a);
        this.getChildren().add(o);
        this.getChildren().add(b);
        this.getChildren().add(e);
        this.getChildren().add(c);
    }

    public boolean checkAnswer()
    {

        return "2".equals(c.getText());
    }

    public String getOperand(int min, int max)
    {
        return "" + ((int)(Math.random() * (max - min)) + min);
    }
    private String getOperator()
    {
        String operator = "";
        int x = (int)(Math.random() * 3) % 3;
        switch (x)
        {
            case 0 -> operator = "+";
            case 1 -> operator = "-";
            case 2 -> operator = "*";
        }
        return operator;
    }

}
