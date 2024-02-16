package com.example.textbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        Circle circle = new Circle();
        circle.setCenterX(100);
         circle.setCenterY(100);
         circle.setRadius(50);
         circle.setStroke(Color.BLACK);
         circle.setFill(Color.WHITE);
        StackPane pane = new StackPane(circle);
        //pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 500, 200);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        /*Stage newStage = new Stage();
        newStage.setTitle("new");
        newStage.setScene(new Scene(new Button("new OK"),200,200));
        newStage.show();*/
    }

    public static void main(String[] args)
    {
        launch();
    }
}