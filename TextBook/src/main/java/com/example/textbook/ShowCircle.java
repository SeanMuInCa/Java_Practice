package com.example.textbook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Purpose:             com.example.textbook<br />
 * Data Submitted:      2024/2/15 <br />
 * Assignment Number:    com.example.textbook<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          com.example.textbook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ShowCircle extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane pane = new Pane();

        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane);

        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }
}
