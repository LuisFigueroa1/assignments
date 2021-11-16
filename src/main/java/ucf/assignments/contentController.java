package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Figueroa
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class contentController implements Initializable{

@FXML
private Button close;
@FXML
private ImageView step1Image;


public void initialize(URL url, ResourceBundle rb) {

}



//closeDocs
Stage stage;
Scene scene;
Parent root;
public void closeButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("home_scene.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

}


}