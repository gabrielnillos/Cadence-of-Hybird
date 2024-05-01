/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package thecadenceofhybird;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class MenuController implements Initializable {

    @FXML private TextField usernameTF;
    
    
    
    public void clickContinue(MouseEvent event) throws IOException {
           
        
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));
        Parent root = loader.load();
        
        LevelScreenController controller = loader.getController();
        controller.generateLevel(Level.getCurrentLevel());
        
        Scene scene = new Scene(root);
        
        
        /*scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("The 'A' key was pressed");
            }
         });*/
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        
            @Override
            public void handle(KeyEvent event){
                System.out.println(event.getCode());
                switch(event.getCode()){
                    case ESCAPE:
                        controller.pauseOpen();
                        break;
                    case UP: 
                        controller.goUp();
                        break;
                    case DOWN: 
                        controller.goDown();
                        break;
                    case LEFT: 
                        controller.goLeft();
                        break;
                    case RIGHT: 
                        controller.goRight();
                        break;
                }
            }
            
                });
    
        
        
        stage.hide();
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void clickLvlSelect(MouseEvent event) throws IOException {
        
        Node component = (Node) event.getSource();
         Stage stageLvl = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stageLvl.hide();
        stageLvl.setScene(scene);
        stageLvl.show();
    }
    
    @FXML public void clickSettings(MouseEvent event) throws IOException {        
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Popup.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Settings");
        Scene scene = new Scene(root, 247, 182);
        stage.setScene(scene);
        stage.show();
        
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void clickQuit(MouseEvent event) throws IOException {
        
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
      
        stage.hide();

    }
    
    public void hoverBtnCont(MouseEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
