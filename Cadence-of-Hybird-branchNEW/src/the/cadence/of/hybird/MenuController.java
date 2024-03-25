/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package the.cadence.of.hybird;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class MenuController implements Initializable {

    @FXML private ImageView backgroundImg;
    @FXML private Button btnCont, btnMap, btnSettings, btnQuit;
    
    @FXML public void clickContinue(MouseEvent event) throws IOException {
        
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));
        Parent root = loader.load();
                
        //LevelScreenController controller = loader.getController();
        //controller.displaySubject(selected);
        Scene scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();

        
        
    }
    
    @FXML public void clickLvlSelect(MouseEvent event) throws IOException {
        
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI.fxml"));
        Parent root = loader.load();
                
        //LevelScreenController controller = loader.getController();
        //controller.displaySubject(selected);
        Scene scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();

        
        
    }
    
    @FXML public void clickSettings(MouseEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error 404: Subject Not Found");
        alert.setHeaderText("ERROR 404: SUBJECT NOT FOUND");
        alert.setContentText("The subject you searched for is not in this list");
        alert.showAndWait();
        
    }
    
    @FXML public void clickQuit(MouseEvent event) throws IOException {
        
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
      
        stage.hide();

    }
    
    @FXML public void hoverBtnCont(MouseEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
