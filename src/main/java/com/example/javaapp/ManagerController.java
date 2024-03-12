package com.example.javaapp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class ManagerController {
    public TableView<User> Chart;
    public TableView Chart2;
    public Text Poorstanding;
    public Text Customers;
    public TableColumn<User, String> GymID;
    public TableColumn <User, String>Visitorname;
    public TableColumn <User, String>VisitorPicture;
    public TableColumn <User, String>amountofVisits;
    public TableColumn<User, String> Standing;
    public TableColumn<User, String> SignedIn;


public void initalize() throws Exception {

    GymID.setCellValueFactory(new PropertyValueFactory<User, String>("GymID"));
    Visitorname.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
    VisitorPicture.setCellValueFactory(new PropertyValueFactory<User, String>("Picture"));
    amountofVisits.setCellValueFactory(new PropertyValueFactory<User, String>("NumofVis"));
    Standing.setCellValueFactory(new PropertyValueFactory<User, String>("Standing"));
    SignedIn.setCellValueFactory(new PropertyValueFactory<User, String>("IsSignedIn"));

    Chart.getItems().addAll(User.allUsers);


}}

