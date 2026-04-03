package com.example.controllers;

import com.example.backend.Route;
import com.example.backend.RouteController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;

public class HomeController {

    @FXML
    private TableView<Route> routeTable;

    @FXML private TableColumn<Route, Integer> colId;
    @FXML private TableColumn<Route, String> colSource;
    @FXML private TableColumn<Route, String> colDestination;
    @FXML private TableColumn<Route, String> colType;
    @FXML private TableColumn<Route, Integer> colSeats;
    @FXML private TableColumn<Route, Double> colPrice;
    @FXML private ImageView backgroundImage;
    @FXML
    private StackPane root;

    @FXML
    private void loadRailwayView(ActionEvent event) {
        System.out.println("Railway clicked");
    }

    @FXML
    private void loadPlaneView(ActionEvent event) {
        System.out.println("Planes clicked");
    }

    @FXML
    private void loadEventView(ActionEvent event) {
        System.out.println("Events clicked");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked");
    }


    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSource.setCellValueFactory(new PropertyValueFactory<>("source"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colSeats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        backgroundImage.fitWidthProperty().bind(root.widthProperty());
        backgroundImage.fitHeightProperty().bind(root.heightProperty());
        routeTable.setItems(
            FXCollections.observableArrayList(RouteController.getRoutes())
        );
    }
}