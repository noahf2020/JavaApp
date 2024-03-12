package com.example.javaapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ManagerController {
    public TableView Chart;
    public Button Logout;
    public Text Poorstanding;
    public Text Customers;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public void logout(ActionEvent event) throws IOException {
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

public void initialize() throws Exception {
System.out.println("Ddd");
    TableColumn<User, String> gymid = new TableColumn<>("GymID");
    gymid.setCellValueFactory(new PropertyValueFactory<User, String>("GymID"));

    TableColumn<User, String> name = new TableColumn<>("Visitorname");
    name.setCellValueFactory(new PropertyValueFactory<User, String>("Visitorname"));


    TableColumn<User, String> visits = new TableColumn<>("amountofVisits");
    visits.setCellValueFactory(new PropertyValueFactory<User, String>("amountofVisits"));

    TableColumn<User, String> RealStand = new TableColumn<>("RealStanding");
    RealStand.setCellValueFactory(new PropertyValueFactory<User, String>("RealStanding"));

    TableColumn<User, String> Signed = new TableColumn<>("SignedIn");
    Signed.setCellValueFactory(new PropertyValueFactory<User, String>("SignedIn"));

    TableColumn<User, String> LastSigned = new TableColumn<>("LastSignin");
    LastSigned.setCellValueFactory(new PropertyValueFactory<User, String>("LastSignin"));

    Chart.getColumns().add(gymid);
    Chart.getColumns().add(name);
    Chart.getColumns().add(visits);
    Chart.getColumns().add(RealStand);
    Chart.getColumns().add(Signed);
    Chart.getColumns().add(LastSigned);


    Chart.getItems().addAll(User.allUsers);


}}

