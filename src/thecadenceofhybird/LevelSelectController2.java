package thecadenceofhybird;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private World destinationWorld, currentWorld;
    private ArrayList<ImageView> levelIconList = new ArrayList<>();
    
    @FXML private Label worldName;
    @FXML private ImageView settingsBtn;
    @FXML private ImageView skBtn;
    @FXML private ImageView ecBtn;
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
        try{
            int selected = 0;
            if(event.getSource() == l8) selected = 7;
            if(event.getSource() == l9) selected = 8;
            if(event.getSource() == l10) selected = 9;
            if(event.getSource() == l11) selected = 10;
            if(event.getSource() == l12) selected = 11;
            
            if(selected == 0 || Level.getLevelByIndex(selected - 1).getEscaped() == true){
                Node component = (Node) event.getSource();
                Stage stage = (Stage) component.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));
                Parent root = loader.load();
                
                LevelScreenController controller = loader.getController();
                controller.setLevel(selected);
                
                Scene scene = new Scene(root);
                stage.hide();
                stage.setScene(scene);
                stage.show();
            }   
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("DO IT IN ORDER");
                alert.setHeaderText("LOCKED: " + Level.getLevelByIndex(selected).getName());
                alert.setContentText("You have to beat the previous level to enter this level!");
                alert.showAndWait();
            }
        }
        catch(IOException e){
        }
    }
    
    @FXML
    private void changeWorld(MouseEvent event) throws IOException {
        // checks if button being clicked is the shadow kingdom button
        if(event.getSource() == skBtn){
            // sets destination of user
            destinationWorld = sk;
            
            //verifies that user is not already in their destination
            if(currentWorld != destinationWorld){
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
        // checks if button being clicked is the snakebird kingdom button
        else if(event.getSource() == ecBtn){ 
            // sets destination of user
            destinationWorld = ec;
            
            //verifies that user is not already in their destination
            if(currentWorld != destinationWorld){
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
    
    @FXML 
    public void clickSettings(MouseEvent event) throws IOException {       
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
    
    public void setLevelIcons() throws NullPointerException {
        try{
            for(int i=0; i<levelIconList.size(); i++){
           
                Level l = Level.getLevelByIndex(i+8);

                if(l.getEscaped() == true){
                    Image img = new Image(getClass().getResourceAsStream("/thecadenceofhybird/images/levelComplete.png"));
                    levelIconList.get(i).setImage(img);
                    System.out.println("Level " + l.getName() + " is complete");
                }
                else if(l.getEscaped() == false){
                    Image img = new Image(getClass().getResourceAsStream("/thecadenceofhybird/images/levelIcon.png"));
                    levelIconList.get(i).setImage(img);
                    System.out.println("Level " + l.getName() + " is incomplete");
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error 404: Subject Not Found");
            alert.setHeaderText("IndexOutOfBoundsException");
            alert.setContentText("we outside");
            alert.showAndWait(); 
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error 404: Level Not Found");
            alert.setHeaderText("NullPointerException");
            alert.setContentText("Level not identified within the list");
            alert.showAndWait(); 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        levelIconList.add(l8);
        levelIconList.add(l9);
        levelIconList.add(l10);
        levelIconList.add(l11);
        levelIconList.add(l12);
       
        currentWorld = ec;
        setLevelIcons();
        
   
    }    
}
