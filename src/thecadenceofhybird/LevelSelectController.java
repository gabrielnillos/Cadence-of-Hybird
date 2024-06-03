package thecadenceofhybird;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ESCAPE;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author MUON
 */
public class LevelSelectController implements Initializable {
    

    
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
            if(event.getSource() == l1) selected = 0;
            if(event.getSource() == l2) selected = 1;
            if(event.getSource() == l3) selected = 2;
            if(event.getSource() == l4) selected = 3;
            if(event.getSource() == l5) selected = 4;
            if(event.getSource() == l6) selected = 5;
            if(event.getSource() == l7) selected = 6;
            
            if(selected == 0 || Level.getLevelProgressList().get(selected - 1).getEscaped() == true){
                Node component = (Node) event.getSource();
                Stage stage = (Stage) component.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));
                Parent root = loader.load();
                LevelScreenController controller = loader.getController();
                controller.setLevel(selected);
                controller.generateLevel(Level.getLevelList().get(selected));
                Level.currentLevel = selected;
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
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("DO IT IN ORDER");
                alert.setHeaderText("LOCKED: " + Level.getLevelProgressList().get(selected).getName());
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
           
                Level l = Level.getLevelProgressList().get(i);

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
        levelIconList.add(l1);
        levelIconList.add(l2);
        levelIconList.add(l3);
        levelIconList.add(l4);
        levelIconList.add(l5);
        levelIconList.add(l6);
        levelIconList.add(l7);

        
        currentWorld = sk;
        setLevelIcons();
        
   
    }    
}
