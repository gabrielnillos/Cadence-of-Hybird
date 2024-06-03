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
 * @author Ghil Tagle
 */
public class InstructionsGUIController implements Initializable {
    @FXML private Button menuBtn;
    
    public void goLvlSelect(MouseEvent event) throws IOException{

        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
