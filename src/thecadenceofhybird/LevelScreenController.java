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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class LevelScreenController implements Initializable {
    private static Level level;
    private static int idx;
    @FXML private ImageView backgroundPic;
    @FXML private GridPane levelGrid;
    
    public int controlledSnakebirdIndex = 0;
    private Snakebird snakebirdInControl;
    public boolean moveStatus;
    
    public void generateLevel(Level levelLoad){
        //Image sbBody = new Image("/body.png"); 
        for(int y = 0; y <= levelLoad.getCoordinates().length -1; y++){
            for(int x = 0; x <= levelLoad.getCoordinates()[y].length -1; x++){
                
                if(levelLoad.getCoordinates()[y][x] == 0){
                    setImageAtIndex(levelGrid, x, y, "empty.png");

                }
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
                    try{setImageAtIndex(levelGrid, x, y, levelLoad.getFoodList().get(0).imageSrc);}
                    catch(Exception e){}

                }
                if(levelLoad.getCoordinates()[y][x] == 52){
                    try{setImageAtIndex(levelGrid, x, y, levelLoad.getFoodList().get(1).imageSrc);}
                    catch(Exception e){}
                }
                if(levelLoad.getCoordinates()[y][x] == 53){
                    try{setImageAtIndex(levelGrid, x, y, levelLoad.getFoodList().get(2).imageSrc);}
                    catch(Exception e){}

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
    @FXML
    private void winLevel(MouseEvent event) throws IOException {
        // win game
        level.setEscaped(true);
        Level.getLevelProgressList().get(idx).setEscaped(true);
        try{
            Level.saveLevels(Level.getLevelProgressList());
            Level.saveCurrentLevel(idx);
            System.out.println("-------------------");
            System.out.println("Snakebird has beaten " + level.getName() + "!");
            System.out.println("-------------------");
            Node component = (Node) event.getSource();
            Stage stage = (Stage) component.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI.fxml"));
            Parent root = loader.load();

            LevelSelectController controller = loader.getController();
            controller.setLevelIcons(); 
            Scene scene = new Scene(root);

            stage.hide();
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){

        }
    } 
        
    void setLevel(int index){
        // set level to be generated when entering a level
        level = Level.getLevelList().get(index);    
        idx = index;
    }
    
    
    public void goUp(){
        System.out.println("up");       
        snakebirdInControl = Level.getCurrentLevel().getSnakebirdList().get(controlledSnakebirdIndex);
        snakebirdInControl.moveUp(Level.getCurrentLevel());
        generateLevel(Level.getCurrentLevel());
        while(snakebirdInControl.amIAnchored(Level.getCurrentLevel()) == false){
            snakebirdInControl.fall(Level.getCurrentLevel());
            generateLevel(Level.getCurrentLevel());
        }
        if(snakebirdInControl.checkWin(Level.getCurrentLevel()) == true){
            System.out.println("congrats");
            Level.currentLevel = Level.currentLevel + 1;
            generateLevel(Level.getCurrentLevel());
        }
    }
    
    public void goDown(){
        System.out.println("down");       
        snakebirdInControl = Level.getCurrentLevel().getSnakebirdList().get(controlledSnakebirdIndex);
        snakebirdInControl.moveDown(Level.getCurrentLevel());
        generateLevel(Level.getCurrentLevel());
        while(snakebirdInControl.amIAnchored(Level.getCurrentLevel()) == false){
            snakebirdInControl.fall(Level.getCurrentLevel());
            generateLevel(Level.getCurrentLevel());
        }
        if(snakebirdInControl.checkWin(Level.getCurrentLevel()) == true){
            System.out.println("congrats");
            Level.currentLevel = Level.currentLevel + 1;
            generateLevel(Level.getCurrentLevel());
        }
    }
    
    public void goLeft(){
        System.out.println("left");          
        snakebirdInControl = Level.getCurrentLevel().getSnakebirdList().get(controlledSnakebirdIndex);
        snakebirdInControl.moveLeft(Level.getCurrentLevel());
        generateLevel(Level.getCurrentLevel());
        while(snakebirdInControl.amIAnchored(Level.getCurrentLevel()) == false){
            snakebirdInControl.fall(Level.getCurrentLevel());
            generateLevel(Level.getCurrentLevel());
        }
        if(snakebirdInControl.checkWin(Level.getCurrentLevel()) == true){
            System.out.println("congrats");
            Level.currentLevel = Level.currentLevel + 1;
            generateLevel(Level.getCurrentLevel());
        }
    }
    
    public void goRight(){
        System.out.println("right");       
        snakebirdInControl = Level.getCurrentLevel().getSnakebirdList().get(controlledSnakebirdIndex);
        snakebirdInControl.moveRight(Level.getCurrentLevel());
        generateLevel(Level.getCurrentLevel());
        while(snakebirdInControl.amIAnchored(Level.getCurrentLevel()) == false){
            snakebirdInControl.fall(Level.getCurrentLevel());
            generateLevel(Level.getCurrentLevel());
        }
        if(snakebirdInControl.checkWin(Level.getCurrentLevel()) == true){
            System.out.println("congrats");
            Level.currentLevel = Level.currentLevel + 1;
            generateLevel(Level.getCurrentLevel());
        }
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