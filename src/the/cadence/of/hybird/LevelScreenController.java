/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package the.cadence.of.hybird;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class LevelScreenController implements Initializable {

    @FXML
    private ImageView backgroundPic;
    @FXML private GridPane gridPane;
    
    public void generateLevel(Level levelLoad){
        for(int y = 0; y <= levelLoad.getCoordinates().length -1; y++){
            for(int x = 0; x <= levelLoad.getCoordinates()[y].length -1; x++){
                if(levelLoad.getCoordinates()[y][x] == 1){
                    
                  ImageView imageView = new ImageView("images/body.png"); 
                  gridPane.add(imageView, x, y);

                }
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
}
