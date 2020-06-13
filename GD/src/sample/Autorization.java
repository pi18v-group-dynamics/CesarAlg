package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Autorization {
    public TextField TFLogin;
    public TextField TFPassword;

    public void ButtonLog(ActionEvent actionEvent) {
            String log ="gosha", password = "qwe123";
            if((TFLogin.getText()).equals(log) && (TFPassword.getText()).equals(password))
        {
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
            Stage stage=new Stage();
            try {
                start(stage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
        TFLogin.clear();
        TFPassword.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Введены неправильный логин или пароль");

        alert.showAndWait();
            }
        }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
        stage.setTitle("Шифровка");
        stage.setScene(new Scene(root, 630, 490));
        stage.setResizable(false);
        stage.show();
        }
}
