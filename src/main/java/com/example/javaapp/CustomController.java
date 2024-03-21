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

    public void logout(ActionEvent event) throws IOException{
        String filePath = "currentUser.txt";
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("");
            System.out.println("String has been written to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }


        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onActionUpload(){
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(stage);
    };

    public void initialize() throws IOException{
        String filePath = "currentUser.txt";

        // Try-with-resources statement to automatically close the resources
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                for (User singleUser: User.allUsers) {
                    String ID =  singleUser.getGymID();
                    if(ID.equals(line)) {
                        System.out.println(singleUser);
                        String Name = singleUser.getVisitorname();
                        Welcomeback.setText("Welcome Back: " +Name);


                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
