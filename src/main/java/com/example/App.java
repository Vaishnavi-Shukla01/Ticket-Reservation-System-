package com.example;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import com.example.backend.DataStore;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        DataStore.loadData();
        // Start the app by loading the login screen first
        scene = new Scene(loadFXML("login"), 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ticket Reservation System");
        stage.show();
    }

    // A static method that any controller can call to change the screen
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Helper method to load the FXML file from the resources folder
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

   public static void setRootWithFade(String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent newRoot = loader.load();

        Parent oldRoot = scene.getRoot();

        // 🔥 Create stack WITHOUT attaching oldRoot yet
        StackPane stack = new StackPane();

        // Set stack as root FIRST
        scene.setRoot(stack);

        // Now safe to add both
        stack.getChildren().addAll(oldRoot, newRoot);

        newRoot.setOpacity(0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), newRoot);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        fadeIn.setOnFinished(e -> {
            scene.setRoot(newRoot); // final clean root
        });

        fadeIn.play();
    }
    public static void main(String[] args) {
        launch();
    }
}