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
        String Code = EnterGym.getText();
        for (User singleUser: User.allUsers) {
               String ID =  singleUser.getGymID();
               if(ID.equals(Code)){
                   save(Code);
                   System.out.println(singleUser.getManager());
                   if(singleUser.getManager()){
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


    }

    public void restore() {



    }


    public void save(String LoginCode) throws IOException {
        String filePath = "currentUser.txt";
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
             bufferedWriter.write(LoginCode);
             System.out.println("String has been written to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}