package com.example.javaapp;

import javafx.collections.ObservableList;
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

import java.io.*;

import static com.example.javaapp.CustomController.currentUser;

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
        currentUser = User.allUsers.get(0);
        String Code = EnterGym.getText();

               String ID =  currentUser.getGymID();
        System.out.println("ID: " + ID );

        System.out.println("EnterCode: " + Code);

               if(ID.contains(Code)){
                   System.out.println("HelloWorld");

                   System.out.println(currentUser.getManager());
                   if(currentUser.getManager()){
                       root = FXMLLoader.load(getClass().getResource("manager.fxml"));
                       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                       scene = new Scene(root);
                       stage.setScene(scene);
                       stage.show();
                   }else{
                       root = FXMLLoader.load(getClass().getResource("customer.fxml"));
                       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                       scene = new Scene(root);
                       stage.setScene(scene);
                       stage.show();
                   }

               }else{
                   System.out.println("Invalid Login");
               }



    }

    public void restore() {



    }



}