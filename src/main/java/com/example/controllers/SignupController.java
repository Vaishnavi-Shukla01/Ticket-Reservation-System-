package com.example.controllers;

import com.example.App;
import com.example.backend.AuthController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


import java.io.IOException;

public class SignupController {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label errorLabel;

    @FXML
    private StackPane root;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void initialize() {

        // 🔥 Responsive background
        backgroundImage.fitWidthProperty().bind(root.widthProperty());
        backgroundImage.fitHeightProperty().bind(root.heightProperty());
    }

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean success = AuthController.register(username, password);

        if (success) {
            System.out.println("User registered");
            App.setRoot("login");
        } else {
            System.out.println("User already exists");
            errorLabel.setText("User already exists");
            errorLabel.setVisible(true);
        }
        
    }

    @FXML
    private void goBackToLogin(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
}