package com.example.javaapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label welcomeText;
    public TextField EnterGym;
    public Button Enter;



    public void initialize() throws Exception {
        User.readData();
    }

    public Stage stage;
    public Scene scene;
    public Parent root;


    public void login(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("customer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restore() {

    }
    public void save() {

    }
}