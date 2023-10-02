package com.example.module03_basicgui_db_interface;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * This class represents a JavaFX application for a basic GUI with a database interface.
 */
public class DB_Application extends Application {

    /**
     * The entry point for the JavaFX application.
     * @param stage The primary stage for the application.
     * @throws IOException If there is an error loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the main GUI
        FXMLLoader fxmlLoader = new FXMLLoader(DB_Application.class.getResource("db_interface_gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 560);

        // Add a stylesheet to the scene
        scene.getStylesheets().add("style.css");

        // Configure the primary stage
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method that launches the JavaFX application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }

    private Stage primaryStage;

    /**
     * Switches to Scene 1 (splash screen).
     */
    private void showScene1() {
        try {
            // Load the FXML file for the splash screen
            Parent root = FXMLLoader.load(getClass().getResource("splash_screen.fxml"));
            Scene scene = new Scene(root, 850, 560);

            // Add a stylesheet to the scene
            scene.getStylesheets().add("style.css");

            // Set the new scene as the primary stage's scene
            primaryStage.setScene(scene);
            primaryStage.show();

            // Change the scene after showing it
            changeScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Changes the current scene to the main GUI with a fade transition effect.
     */
    public void changeScene() {
        try {
            // Load the FXML file for the main GUI
            Parent newRoot = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));

            // Get the current scene and root
            Scene currentScene = primaryStage.getScene();
            Parent currentRoot = currentScene.getRoot();

            // Add a stylesheet to the current scene
            currentScene.getStylesheets().add("style.css");

            // Create a fade-out animation for the current root
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), currentRoot);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);

            // Set the action to be performed when the fade-out animation finishes
            fadeOut.setOnFinished(e -> {
                // Create a new scene with the new root and set it as the primary stage's scene
                Scene newScene = new Scene(newRoot, 850, 560);
                primaryStage.setScene(newScene);
            });

            // Start the fade-out animation
            fadeOut.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
