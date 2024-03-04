package com.example.javaapp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomController {
    public Label PFP;
    public Label Standing;
    public Label AOV;

    public Button Uploadpicture;
    public Button LOGOUT;

    public void logout(){
    }
    public void uploadPic(){
    }
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

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
