package sisyphus.WikiReaper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author Olalekan Adebari ( nee Sisyphus )
 **/
public class readMoreController  implements  Initializable{

    @FXML
    private Label readMoreHeading;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        readMoreHeading.setText(""); //TODO the label of this Label will be  the wikipedia title of the article returned by the API


    }
}

