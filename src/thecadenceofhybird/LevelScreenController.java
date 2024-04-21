/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package thecadenceofhybird;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class LevelScreenController implements Initializable {

    @FXML private ImageView backgroundPic;
    @FXML private GridPane levelGrid;
    
        
   
    /*
    
    Image sbHead = new Image("images/head.png");
    Image lvlGround = new Image("images/ground.jpg");
    Image foodCherry = new Image("images/cherry.png"); 
    Image lvlPortal = new Image("images/portal.png");
    */
    
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
}
