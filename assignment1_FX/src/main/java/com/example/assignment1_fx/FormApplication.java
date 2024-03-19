package com.example.assignment1_fx;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import java.io.IOException;

public class FormApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        BorderPane obPane = new BorderPane();

        initStage(obPane);

        Scene scene = new Scene(obPane);
        stage.setTitle("Student Information Form!");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.show();
    }

    private void initStage(BorderPane obPane)
    {
        StudentForm pane = new StudentForm();
        obPane.setCenter(pane);
        Controller controller = new Controller(pane);
        obPane.setBottom(controller);
    }

    public static void main(String[] args)
    {
        launch();
    }
}