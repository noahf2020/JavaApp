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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ManagerController {
    public TableView Chart;
    public Button Logout;
    public Text Poorstanding;
    public Text Customers;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public void logout(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

public void initialize() throws Exception {

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
    try {
        restore();
    } catch (Exception ex) {
        System.out.println(ex);
    }
}

    public void saveObject() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("data");
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        ObservableList<User> users = Chart.getItems();
        objOutputStream.writeInt(users.size());
        for (User user : users) {
            objOutputStream.writeObject(user);
        }
        objOutputStream.flush();
        objOutputStream.close();
        outputStream.close();
    }

    void restore() throws Exception {
        FileInputStream inputStream = new FileInputStream("data");
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        int numOfSavedObjects = objInputStream.readInt();
        List<User> Users = new ArrayList<>();
        for (int i = 0; i < numOfSavedObjects; i++) {
            User user = (User) objInputStream.readObject();
            Users.add(user);
        }
        objInputStream.close();
        inputStream.close();
        Chart.getItems().addAll(Users);
    }

}

