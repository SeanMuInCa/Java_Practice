package com.example.assignment1_fx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.ArrayList;

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
    private final Button btLoad = new Button("Load Data");
    private final Button btPre = new Button("< Previous");
    private final Button btNext = new Button("Next >");
    private final Button btSave = new Button("Save");
    int index = 0;
    int position = 0;
    Student[] array;
    ArrayList<Integer> saved = new ArrayList<>();

    /**
     * initial everything
     * @param form data form
     */
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
        btNext.setDisable(true);
        btPre.setDisable(true);
        btLoad.setOnAction(e ->
        {
            loadData(index);
            btLoad.setDisable(true);
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

    /**
     * set next and pre button's status
     */
    private void setButton()
    {
        btPre.setDisable(index == 0);
        btNext.setDisable(index == 9);
    }

    /**
     * set save button's status based on current data is saved or not
     * @param i index
     */
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

    /**
     * load the data from the file by index
     * @param index index
     */
    private void loadData(int index)
    {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objforarray.dat"))
        )
        {

            array = (Student[]) ois.readObject();
            Student s = array[index];
            form.name.setText(s.getName());
            form.number.setText(s.getStudentNumber());
            form.program.setText(s.getProgram());
            String[] courses = s.getCourses();
            StringBuilder res = new StringBuilder();
            if (courses != null)
            {
                for (String cours : courses)
                {
                    res.append(cours).append("\n");
                }
            }
            form.textArea.setText(res.toString());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * save the data to file by index
     * @param index index
     */
    private void saveData(int index)
    {

        try (

                RandomAccessFile operator = new RandomAccessFile("test.dat", "rw");
        )
        {
            System.out.println("position = " + position);
            Student student = array[index];
            operator.seek(position);
            writeObject(student);
            position += operator.length();

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void writeObject(Student student) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.dat"));
        oos.writeObject(student);
        oos.flush();
    }
}
