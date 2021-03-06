package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Autorization.fxml"));
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
