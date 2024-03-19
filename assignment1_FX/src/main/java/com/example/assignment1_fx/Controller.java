package com.example.assignment1_fx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
public class Controller extends HBox implements Serializable
{
    StudentForm form;
    private Button btLoad = new Button("Load Data");
    private Button btPre = new Button("< Previous");
    private Button btNext = new Button("Next >");
    private Button btSave = new Button("Save");
    int index = 0;
    Student[] array;
    ArrayList<Integer> saved = new ArrayList<>();

    public Controller(StudentForm form)
    {
        btLoad.setPadding(new Insets(6));
        btPre.setPadding(new Insets(6));
        btNext.setPadding(new Insets(6));
        btSave.setPadding(new Insets(6));
        this.setSpacing(20);
        this.getChildren().add(btLoad);
        this.getChildren().add(btPre);
        this.getChildren().add(btNext);
        this.getChildren().add(btSave);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(30));
        GridPane.setHalignment(btNext, HPos.RIGHT);
        this.form = form;
        btSave.setDisable(true);
        btLoad.setOnAction(e ->
        {
            loadData(index);
            setButton();
            btSave.setDisable(false);
            setSaveBtn(index);
        });
        btNext.setOnAction(e ->
        {
            index = index < 9 ? index + 1 : 9;
            loadData(index);
            setButton();
            setSaveBtn(index);
        });
        btPre.setOnAction(e ->
        {
            index = index > 0 ? index - 1 : 0;
            loadData(index);
            setButton();
            setSaveBtn(index);
        });
        btSave.setOnAction(e ->
        {
            saveData(index);
            saved.add(index);
            btSave.setDisable(true);
        });
    }

    private void setButton()
    {
        if (index == 0) btPre.setDisable(true);
        else btPre.setDisable(false);
        if (index == 9) btNext.setDisable(true);
        else btNext.setDisable(false);
    }
    private void setSaveBtn(int i)
    {
        System.out.println(saved);
        System.out.println(i);
        if(saved.contains(i))
        {
            btSave.setDisable(true);
            return;
        }
        btSave.setDisable(false);
    }

    private void loadData(int index)
    {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objforarray.dat"));
        )
        {

            array = (Student[]) ois.readObject();
            Student s = array[index];
            form.name.setText(s.getName());
            form.number.setText(s.getStudentNumber());
            form.program.setText(s.getProgram());
            String[] courses = s.getCourses();
            String res = "";
            if (courses != null)
            {
                for (int i = 0; i < courses.length; i++)
                {
                    res += courses[i] + "\n";
                }
            }
            form.textArea.setText(res);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void saveData(int index)
    {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
        )
        {
            Student student = array[index];
            System.out.println(student);
            oos.writeObject(student);

        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
