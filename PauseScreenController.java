/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package thecadenceofhybird;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Nillos
 */
public class PauseScreenController implements Initializable {

        @FXML private Button menuBtn, settingsBtn, resumeBtn;
    
        public void goMenu(MouseEvent event) throws IOException{
            
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.hide();
        stage.setScene(scene);
        stage.show();
        }
        
@FXML public void goSettings(MouseEvent event) throws IOException {        
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Popup.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Settings");
        Scene scene = new Scene(root, 250, 407);
        stage.setScene(scene);
        stage.show();
        
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }        
        public void goResume(MouseEvent event) throws IOException{
            Node component = (Node) event.getSource();
            Stage stage = (Stage) component.getScene().getWindow();    
            stage.close();
        
        }
        
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}