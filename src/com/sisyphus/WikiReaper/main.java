package sisyphus.WikiReaper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author Olalekan Adebari ( nee Sisyphus )
 **/
public class main extends Application{

    public static void main(String[] args) {
       launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("/Resources/fxml/reaperGUI.fxml"));
        primaryStage.setTitle("Article Reaper");
        Scene newScene = new Scene(loader);
        primaryStage.setScene(newScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
