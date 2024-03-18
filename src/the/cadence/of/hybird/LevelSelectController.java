package the.cadence.of.hybird;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author MUON
 */
public class LevelSelectController implements Initializable {
    
    
    
    @FXML private Label worldName;
    @FXML private ImageView l1,l2,l3,l4,l5,l6,l7,completeIndicator, settingsBtn;
    
    @FXML
    private void enterLevel(ActionEvent event, Level level) {
        System.out.println("Entering: " );
        worldName.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
