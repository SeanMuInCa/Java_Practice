package com.example.assignment3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class StartRaceTrack extends Application
{
    //ImageView obCar ;
//    ArrayList<Player> obPlayers = new ArrayList<>();
//    Game obGame;
    CarPane obTrack;
    CarPane obTrack2;

    Timeline obTimeRace;
    Timeline obTimeRace2;
    Timeline answer;

    ControlBox obControl;
    Stage obMainStage;


    MenuItem miStart;
    MenuItem miPause;
    MenuItem miRestart;

    @Override
    public void start(final Stage obStage) throws Exception
    {

        //Race car and Track
        obTrack = new CarPane();

        //Reference Car and Track
        obTrack2 = new CarPane();
        obTrack2.setStyle("-fx-background-color: lightgrey");

        //Set up the reference car's animation
        obTimeRace2 = new Timeline(new KeyFrame(Duration.millis(100), x ->
        {
            obTrack2.move();
        }));
        obTimeRace2.setCycleCount(Timeline.INDEFINITE);
        obTimeRace2.play();

        //Set up the race car's animation
        obTimeRace = new Timeline(new KeyFrame(Duration.millis(100), x -> obTrack.move()));
        obTimeRace.setCycleCount(Timeline.INDEFINITE);
        obTimeRace.play();


        VBox obCarBox = new VBox(40);

        obCarBox.setAlignment(Pos.TOP_CENTER);

        obCarBox.getChildren().addAll(obTrack2, obTrack);
        obCarBox.setPadding(new Insets(40, 0, 0, 0));


        //A border pane, top area for menu bar, bottom for the game control, center for tracks/cars
        BorderPane obPane = new BorderPane(obCarBox);
        obPane.setPadding(new Insets(10, 0, 10, 0));

        obPane.setTop(createMenuBar());

        // Create and add the game control, and the menu bar to the obPane
        obControl = new ControlBox();
        obPane.setBottom(obControl);
        //obControl.initQuestion();
        //todo add a timer and after 5 sec no answer re new
        //todo why 2nd time not finish?
        answer = new Timeline(new KeyFrame(Duration.seconds(5), t -> {
            System.out.println("every 5 seconds");
            obControl.initQuestion();
        }));
        answer.setCycleCount(Timeline.INDEFINITE);
        obControl.setOnKeyReleased(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                //System.out.println(obControl.getResult());
                if (obControl.checkAnswer(obControl.getResult().trim()))
                {
                    System.out.println("jiasu");
                    obTrack.speedUp();
                } else
                {
                    System.out.println("jiansu");
                    obTrack.slowDown();
                }
                answer.stop();
                answer.play();
                obControl.initQuestion();
            }
        });
        obControl.setDisable(true);

        Scene obScene = new Scene(obPane, 1200, 400);
        //Bind tracks' width with the scene
        obScene.widthProperty().addListener(e ->
        {
            obTrack.setW(obScene.getWidth());
            obTrack2.setW(obScene.getWidth());
        });

        //Register the listener when the current game is finished
        obTrack.raceFinishedProperty().addListener(e ->
        {
            System.out.println(e);
            obTrack.resetRace();
            obTrack2.resetRace();
            obControl.setDisable(true);
            createResult(obTrack);
        });

        obTrack2.raceFinishedProperty().addListener(e ->
        {
            System.out.println(e);
            obTrack.resetRace();
            obTrack2.resetRace();
            obControl.setDisable(true);
            createResult(obTrack2);
        });


        obStage.setScene(obScene);

        obStage.setTitle("Racing in Saskatchewan");

        obMainStage = obStage;

        obMainStage.show();
    }

    private MenuBar createMenuBar()
    {
        MenuBar obBar = new MenuBar();

        obBar.getMenus().addAll(createFileMenu(), createHelpMenu());

        return obBar;
    }
    private void run()
    {
        obControl.setDisable(false);
        obTrack2.setDx(2);
        miStart.setDisable(true);
        miPause.setDisable(false);
        answer.play();
    }

    private Menu createFileMenu()
    {
        AtomicInteger speed = new AtomicInteger();
        Menu mnFile = new Menu("File");
        miStart = new MenuItem("Start");

        miPause = new MenuItem("Pause");
        miPause.setDisable(true);

        miRestart = new MenuItem("ReStart");
        miRestart.setVisible(false);
        SeparatorMenuItem obSpacer = new SeparatorMenuItem();

        MenuItem miExit = new MenuItem("Exit");

        mnFile.getItems().addAll(miStart, miPause, miRestart,obSpacer, miExit);


        //Set event handler for start menu item
        miStart.setOnAction(e ->
        {
            run();
        });
        //Set event handler for pause menu item
        miPause.setOnAction(e ->
        {
            speed.set(obTrack.getDx());
            obTrack2.setDx(0);
            obTrack.setDx(0);
            miStart.setDisable(true);
            miPause.setVisible(false);
            miRestart.setVisible(true);
            answer.stop();
            obControl.setDisable(true);
            System.out.println(speed);
        });
        miRestart.setOnAction(e -> {
            run();
            obTrack.setDx(speed.get());
            //obTrack2.setDx(obTrack2.getDx());
            miStart.setDisable(true);
            miPause.setVisible(true);
            miRestart.setVisible(false);
            obControl.initQuestion();
            answer.play();
        });

        miExit.setOnAction(e -> obMainStage.close());
        return mnFile;
    }

    private Menu createHelpMenu()
    {
        Menu mnHelp = new Menu("Help");

        MenuItem miAbout = new MenuItem("About");

        mnHelp.getItems().add(miAbout);

        // Set up the event handler
        miAbout.setOnAction(e ->
        {
            final Stage dialogStage = new Stage();

            dialogStage.setTitle("About the author of the game");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(obMainStage);

            VBox dialogBox = new VBox(40);

            dialogBox.setPadding(new Insets(30, 30, 30, 30));
            dialogBox.getChildren().add(new Text("This game is developed by:\n\n       George Ding\n     " +
                    "  SDC Instructor\n      Saskatchewan Polytechnic\n      SK, Canada"));


            HBox obHBox = new HBox(40);
            Button obButtonClose = new Button("Close");

            obHBox.getChildren().add(obButtonClose);

            dialogBox.getChildren().add(obHBox);

            obButtonClose.setOnAction(t -> dialogStage.close());

            Scene dialogScene = new Scene(dialogBox, 350, 200);

            dialogStage.setScene(dialogScene);

            dialogStage.show();
        });

        return mnHelp;
    }

    private void createResult(CarPane car)
    {
        final Stage dialogStage = new Stage();

        dialogStage.setTitle("Result of the race!");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initOwner(obMainStage);

        VBox dialogBox = new VBox(40);

        dialogBox.setPadding(new Insets(30, 30, 30, 30));

        dialogBox.getChildren().add(new Text(car == obTrack2 ? "Computer Win" : "You Win"));


        HBox obHBox = new HBox(40);
        Button obButtonClose = new Button("Close");
        Button obButtonRestart = new Button("Restart");

        obHBox.getChildren().add(obButtonClose);
        obHBox.getChildren().add(obButtonRestart);

        dialogBox.getChildren().add(obHBox);

        obButtonClose.setOnAction(t -> obMainStage.close());
        obButtonRestart.setOnAction(t -> {
            dialogStage.close();
            new StartRaceTrack();
            miStart.setDisable(false);
            miPause.setDisable(true);
        });
        Scene dialogScene = new Scene(dialogBox, 350, 200);

        dialogStage.setScene(dialogScene);

        dialogStage.show();


    }
}
