package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Figueroa
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class homeController {

    //Define FXML objects
    //buttons
    @FXML
    private Button add;
    @FXML
    private Button create;
    @FXML
    private Button importButton;
    @FXML
    private Button deleteSelected;
    @FXML
    private Button deleteAll;
    @FXML
    private Button export;
    @FXML
    private Button status;



    //Misc
    @FXML
    private ButtonBar toolBar;
    @FXML
    private TextField taskNameField;
    @FXML
    private TextField taskListField;
    @FXML
    private DatePicker dueDateField;
    @FXML
    private Label taskListName;

    //Table
    @FXML
    private TableView <taskRef> taskTable;
    @FXML
    private TableColumn<taskRef, String> taskNameCol;
    @FXML
    private TableColumn<taskRef, String> dueDateCol;;
    @FXML
    private TableColumn<taskRef, String> statusCol;



    //create list
    public void createTask(){


        taskListName.setText(taskListField.getText());

        if(taskListName != null) {

            toolBar.setDisable((false));
            dueDateField.setDisable(false);
            taskNameField.setDisable(false);
            taskNameField.setDisable(false);
            add.setDisable(false);

        }else{
            taskListName.setText(taskListField.getText());
        }


    }
    //add a new task
    public void addTask() {

        String selectedDate = dueDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // add a task
        taskRef newTaskRef = new taskRef(taskNameField.getText(),
                selectedDate,
                "In Process");


        var result = taskTable.getItems().add(newTaskRef);
    }


    //delete task
    public void deleteSelectedPushed() {
        ObservableList<taskRef> selectedRows, allPeople;
        allPeople = taskTable.getItems();

        //this gives us the rows that were selected
        selectedRows = taskTable.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (taskRef taskRef : selectedRows)
        {
            allPeople.remove(taskRef);

        }
    }
    //complete task
    public void statusPushed() {
        ObservableList<taskRef> selectedRows, allPeople;
        allPeople = taskTable.getItems();

        //this gives us the rows that were selected

        selectedRows = taskTable.getSelectionModel().getSelectedItems();
        for (taskRef task : selectedRows) {

                taskRef newTaskRef = new taskRef(task.getTaskName(),
                        task.getDueDate(),
                        "Completed");

                taskTable.getItems().add(newTaskRef);

                allPeople.remove(task);

        }


//        Person editedPerson = new Person(selectedRows., "hola","hola");
//        taskTable.getItems().add(newPerson)
        //loop over the selected rows and remove the Person objects from the table




    }
    //delete All
    public void deleteAllPushed() {

        taskTable.getItems().clear();
    }
    //export list
    public void exportPushed() {

        //create file
        try {
            File myObj = new File(taskListName.getText() + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //write taskList

            var allTask  =  taskTable.getItems();
           ;
            for (taskRef task : allTask) {
                System.out.println(task.getTaskName() + "," + task.getDueDate() + task.getStatus() + "\n");
            }

        try {

            FileWriter myWriter = new FileWriter(taskListName.getText() + ".txt");
            for (taskRef task : allTask) {
                myWriter.write(task.getStatus() + "," + task.getTaskName() + "," + task.getDueDate()  + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
    //import a list
    public void importList() {
        try {
            File myObj = new File(taskListField.getText() + ".txt");

            taskListName.setText(taskListField.getText());

            Scanner read = new Scanner (new File(taskListField.getText() + ".txt"));
            read.useDelimiter(",");
            String status, description, rDueDate;

            while (read.hasNextLine()) {

                status = read.next();
                description = read.next();
                rDueDate = read.nextLine();



                taskRef newTaskRef = new taskRef(description,
                        rDueDate, status);

                taskTable.getItems().add(newTaskRef);
                System.out.println(newTaskRef);

            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    //get All tasks

    //change scene
    Stage stage;
    Scene scene;
    Parent root;

    public void goToDocs(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("content_scene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //Initialize table
    public void initialize(){
        //set up the columns in the table
        taskNameCol.setCellValueFactory(new PropertyValueFactory<taskRef, String>("taskName"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<taskRef, String>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<taskRef, String>("status"));


        //set everything editable = false
        toolBar.setDisable((true));
        dueDateField.setDisable(true);
        taskNameField.setDisable(true);
        taskNameField.setDisable(true);
        add.setDisable(true);

        dueDateField.setValue(LocalDate.now());
        taskTable.setEditable(true);
        //statusCol.setCellFactory(TextFieldTableCell.forTableColumn());
        taskNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateCol.setCellFactory(TextFieldTableCell.forTableColumn());

    }





    }