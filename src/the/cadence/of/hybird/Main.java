/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package the.cadence.of.hybird;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel Nillos
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] coordinates = new int[12][21];
        
        Level lvl1 = new Level("Level 1", coordinates);
        Level lvl2 = new Level("Level 2", coordinates);
        Level lvl3 = new Level("Level 3", coordinates);
        Level lvl4 = new Level("Level 4", coordinates);
        Level lvl5 = new Level("Level 5", coordinates);
        Level lvl6 = new Level("Level 6", coordinates);
        Level lvl7 = new Level("Level 7", coordinates);
        
        launch(args);
    }
    
}
