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
    private int res;

    public ControlBox()
    {
        a = new Label();
        b = new Label();
        o = new Label();

        e = new Label(" = ");
        c = new TextField();
        initQuestion();
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

    public void initQuestion()
    {
        String operator = getOperator();
        if(operator.equals("*"))
        {
            a.setText(getOperand(1,12));
            b.setText(getOperand(1,12));
            res = Integer.parseInt(a.getText()) * Integer.parseInt(b.getText());
        }else
        {
            a.setText(getOperand(1,100));
            b.setText(getOperand(1,100));
            if("-".equals(operator))
            {
                res = Integer.parseInt(a.getText()) - Integer.parseInt(b.getText());
            }else res = Integer.parseInt(a.getText()) + Integer.parseInt(b.getText());
        }
        o.setText(operator);
        c.setText("");

    }
    public boolean checkAnswer(String result)
    {

        return res == Integer.parseInt(c.getText());
    }

    public String getResult(){
        return c.getText();
    }
    public String getOperand(int min, int max)
    {
        return "" + ((int)(Math.random() * (max - min)) + min);
    }
    public String getOperator()
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
