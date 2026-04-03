package com.example.controllers;

import com.example.App;
import com.example.backend.AuthController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginController {

    // These link directly to the fx:id in your FXML
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label errorLabel;

    @FXML
    private StackPane root;

    @FXML
    public void initialize() {
        backgroundImage.fitWidthProperty().bind(root.widthProperty());
        backgroundImage.fitHeightProperty().bind(root.heightProperty());
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        // Here is how you grab the text the user typed:
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        boolean success = AuthController.login(username, password);

        if (success) {
            System.out.println("Login successful");
            App.setRoot("home");
        } else {
            System.out.println("Invalid credentials");
            errorLabel.setText("Invalid credentials");
            errorLabel.setVisible(true);
        }
         
    }

    @FXML
    private void goToSignup(ActionEvent event) throws IOException {
        App.setRoot("signup"); 
    }
}