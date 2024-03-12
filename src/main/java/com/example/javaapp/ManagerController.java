package com.example.javaapp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class ManagerController {
    public TableView Chart;

    public Text Poorstanding;
    public Text Customers;



public void initialize() throws Exception {
System.out.println("Ddd");
    TableColumn<User, String> gymid = new TableColumn<>("GymID");
    gymid.setCellValueFactory(new PropertyValueFactory<User, String>("GymID"));

    TableColumn<User, String> name = new TableColumn<>("Visitorname");
    name.setCellValueFactory(new PropertyValueFactory<User, String>("Visitorname"));

    Chart.getColumns().add(gymid);
    Chart.getColumns().add(name);

    Chart.getItems().addAll(User.allUsers);


}}

