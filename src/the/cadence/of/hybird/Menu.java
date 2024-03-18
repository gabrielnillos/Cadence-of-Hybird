/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Randy Remonte
 */
public class Menu extends Application {
    
    @Override
     primaryStage.setTitle("Cadence of Hybrid");
        
        /* Setting a layout */
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        
        
        Button button = new Button("Continue");
        JLabel ();
        Button button = new Button("World Map");
        Button button = new Button("Settings");
        Button button = new Button("Quit");
        root.getChildren().add(button);
        
        primaryStage.show();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
