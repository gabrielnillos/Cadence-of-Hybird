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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author MUON
 */
public class LevelSelectController2 implements Initializable {
    
    World sk = new World("Snakebird Kingdom", "skIcon", "LevelSelectGUI");
    World ec = new World("Evil Castle", "ecIcon", "LevelSelectGUI2");
    
    private boolean isComplete;
    private World world, currentWorld;
    @FXML private Label worldName;
    @FXML private ImageView settingsBtn;
    @FXML private ImageView skBtn;
    @FXML private ImageView ecBtn;
    @FXML private ImageView completeIndicator;
    @FXML private ImageView l1;
    @FXML private ImageView l2;
    @FXML private ImageView l3;
    @FXML private ImageView l4;
    @FXML private ImageView l5;
    @FXML private ImageView l6;
    @FXML private ImageView l7;
    @FXML private ImageView l8;
    @FXML private ImageView l9;
    @FXML private ImageView l10;
    @FXML private ImageView l11;
    @FXML private ImageView l12;
    
    @FXML
    private void enterLevel(MouseEvent event) throws IOException {
        Node component = (Node) event.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));
        Parent root = loader.load();
               
        Scene scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void changeWorld(MouseEvent event) throws IOException {
        if(event.getSource() == skBtn){
            world = sk;
            if(currentWorld != world){
                currentWorld = sk;
                
                Node component = (Node) event.getSource();
                Stage stage = (Stage) component.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage.hide();
                stage.setScene(scene);
                stage.show();
            }
        }
        else if(event.getSource() == ecBtn){ 
            world = ec;
            if(currentWorld != world){
                currentWorld = ec;
                Node component = (Node) event.getSource();
                Stage stage = (Stage) component.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelectGUI2.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage.hide();
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    
    @FXML public void clickSettings(MouseEvent event) throws IOException {
               
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Popup.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Settings");
        Scene scene = new Scene(root, 300, 190);
        stage.setScene(scene);
        stage.show();
        
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentWorld = ec;
    }    
}
