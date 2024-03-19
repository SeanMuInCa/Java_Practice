package com.example.assignment1_fx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Purpose:             com.example.assignment1_fx<br />
 * Data Submitted:      2024/3/18 <br />
 * Assignment Number:    com.example.assignment1_fx<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          com.example.assignment1_fx <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class StudentForm extends StackPane
{
    GridPane pane = new GridPane();
    TextField number = new TextField();
    TextField name = new TextField();
    TextField program = new TextField();
    TextArea textArea = new TextArea();
    public StudentForm()
    {
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(30);
        pane.add(new Label("Student #: "), 0, 0);

        pane.add(number, 1, 0);
        pane.add(new Label("Name: "), 0, 1);

        pane.add(name, 1, 1);
        pane.add(new Label("Program: "), 0, 2);

        pane.add(program, 1, 2);
        pane.add(new Label("Courses: "), 0, 3);

        textArea.setWrapText(true);
        textArea.setMaxWidth(200);
        textArea.setMaxHeight(100);
        pane.add(textArea,1,3);
        this.getChildren().add(pane);
    }


}
