package sisyphus.WikiReaper;

import com.jfoenix.controls.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import static sisyphus.WikiReaper.Reaper.connectArticleTitleToAPI;
import static sisyphus.WikiReaper.Reaper.getTitle;

/**
 * @Author Olalekan Adebari ( nee Sisyphus )
 **/
public class Controller implements Initializable {

    @FXML
    private JFXButton searchButton;

    @FXML
    private  JFXTextField searchTextField;

    @FXML
    private JFXTextArea resultTextArea;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private JFXHamburger burger;

    @FXML
    private JFXRippler rippler;

    JFXButton readMore;

    int lineNumbers;
    String text;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchTextField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal){
                searchTextField.validate();
            }
        });




        /////////////////////////////////////////////////////////
        searchButton.getStyleClass().add("button-raised");
        this.searchButton.setOnAction(e -> {
            try {
                buttonPressed();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });
    }


    @FXML
    public String buttonPressed() throws UnsupportedEncodingException {

    /*Thread daoThread = new Thread(new Runnable() {
        @Override
        public void run() {

            try {
                text = (connectArticleTitleToAPI(getTitle(searchTextField.getText())));
                System.out.println("what the helle");
                 lineNumbers = text.length() / 65;
                System.out.println(text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    });
    daoThread.start();*/


        try {
            text = (connectArticleTitleToAPI(getTitle(searchTextField.getText())));
            System.out.println("what the helle");
            lineNumbers = text.length() / 65;
            System.out.println(text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

       mainAnchorPane.getScene().getWindow().setHeight(500);
        resultTextArea.prefHeightProperty().bind(mainAnchorPane.getScene().getWindow().heightProperty());
        searchTextField.textFormatterProperty().addListener(new ChangeListener<TextFormatter<?>>() {
            @Override
            public void changed(ObservableValue<? extends TextFormatter<?>> observable, TextFormatter<?> oldValue, TextFormatter<?> newValue) {
                if (newValue == ){
                    mainAnchorPane.getScene().getWindow().setHeight(99.0);
                }
            }
        });
            resultTextArea.setText(text);

        return text;
    }

    private String editWithRegex(String s) {

        return s;
    }

    @FXML
    public void handleReadMore() {


    }

    public JFXDialog handleException(Exception e ){

        return null;

    }







}
