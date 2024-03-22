package com.example.javaapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class CustomController {
    public Label PFP;
    public Label Standing;
    public Label AOV;
    public Text Welcomeback;

    public Button Uploadpicture;
    public Button LOGOUT;
    public Stage stage;
    public Scene scene;
    public Parent root;

    static User currentUser;

    public void logout(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onActionUpload() {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(stage);
    }

    ;

    public void initialize() throws IOException {
        currentUser = User.allUsers.get(0);


        System.out.println(currentUser);
        String Name = currentUser.getVisitorname();
        Welcomeback.setText("Welcome Back: " + Name);


    }

}
