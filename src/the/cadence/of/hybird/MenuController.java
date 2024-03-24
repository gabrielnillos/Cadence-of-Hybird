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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
