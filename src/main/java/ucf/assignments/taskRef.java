package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Figueroa
 */

import javafx.beans.property.SimpleStringProperty;


public class taskRef {
    private SimpleStringProperty taskName;
    private SimpleStringProperty dueDate;
    private SimpleStringProperty status;



    public taskRef(String taskName, String dueDate, String status ){
        this.taskName = new SimpleStringProperty(taskName);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.status =  new SimpleStringProperty(status);


    }


    public String getStatus() {
        return status.get();
    }

    public void setStatus( String status) {
        this.status =  new SimpleStringProperty(status);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(String dueDate) {
        this.dueDate = new SimpleStringProperty(dueDate);
    }

    public String getTaskName() {
        return taskName.get();
    }

    public void setTaskName(String taskName) {

        this.taskName = new SimpleStringProperty(taskName);
    }

    public String toString()
    {
        return String.format("%s %s %s", status, taskName,  dueDate);
    }


}