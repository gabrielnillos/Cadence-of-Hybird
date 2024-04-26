/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package thecadenceofhybird;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class LevelScreenController implements Initializable {

    @FXML private ImageView backgroundPic;
    @FXML private GridPane levelGrid;
    
    
    
    public void generateLevel(Level levelLoad){
        //Image sbBody = new Image("/body.png"); 
        for(int y = 0; y <= levelLoad.getCoordinates().length -1; y++){
            for(int x = 0; x <= levelLoad.getCoordinates()[y].length -1; x++){
                if(levelLoad.getCoordinates()[y][x] == 1){
                    setImageAtIndex(levelGrid, x, y, "ground.jpg");

                }
                if(levelLoad.getCoordinates()[y][x] == 3){
                    setImageAtIndex(levelGrid, x, y, "head.png");

                }
                if(levelLoad.getCoordinates()[y][x] == 4){
                    setImageAtIndex(levelGrid, x, y, "body.png");

                }
                if(levelLoad.getCoordinates()[y][x] == 51){
                    setImageAtIndex(levelGrid, x, y, "cherry.png");

                }
                if(levelLoad.getCoordinates()[y][x] == 9){
                    setImageAtIndex(levelGrid, x, y, "bground.jpg");

                }
                if(levelLoad.getCoordinates()[y][x] == 10){
                    setImageAtIndex(levelGrid, x, y, "portal.png");

                }
            }
        }
    }
    
    private void setImageAtIndex(GridPane gridPane, int columnIndex, int rowIndex, String fileName) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == columnIndex && GridPane.getRowIndex(node) == rowIndex && node instanceof ImageView) {
            // Load image from file
            try {
                // Load image from file
                Image image = new Image(getClass().getResource("/thecadenceofhybird/images/" + fileName).toExternalForm());
                ((ImageView) node).setImage(image); // Set image to ImageView
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
                e.printStackTrace();
            }
            break;
        }
    }
}
    
    
    public void pauseOpen() {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseScreen.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Paused");
        Scene scene = new Scene(root, 241, 407);
        stage.setScene(scene);
        stage.show();
        
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void goUp(){
        System.out.println("up");
    }
    
    public void goDown(){
        System.out.println("down");        
    }
    
    public void goLeft(){
        System.out.println("left");        
    }
    
    public void goRight(){
        System.out.println("right");        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
}
}