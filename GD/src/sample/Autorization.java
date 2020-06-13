package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Autorization {
    public TextField TFLogin;
    public TextField TFPassword;

    public void ButtonLog(ActionEvent actionEvent) throws IOException {

        Scanner sc = new Scanner(new File("LogAndPassword"));
        String log =TFLogin.getText(),
               password = TFPassword.getText();
        String[] str1 = new String[10];
        List<String> list = new ArrayList<String>();
        String LOGIN="";
        String PASSWORD="";

        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        str1 = list.toArray(new String[0]);
        for (int j=0;j<str1.length-1;j++){
            if(str1[j].equals(log))
                if(str1[j+1].equals(password)){
                    LOGIN = str1[j];
                    PASSWORD = str1[j+1];
                    break;
                }
        }

            if((LOGIN).equals(log) && (PASSWORD).equals(password))
        {
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
            if(log.equals("admin")){
            Stage stage=new Stage();
            try {
                start(stage,"AdminForm.fxml");

            } catch (Exception e) {
                e.printStackTrace();
            }
            }else{
                Stage stage=new Stage();
                try {
                    start(stage,"MainForm.fxml");

                } catch (Exception e) {
                    e.printStackTrace();
                }}
        } else{
        TFLogin.clear();
        TFPassword.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Введены неправильный логин или пароль");

        alert.showAndWait();
            }
        }

    public void start(Stage stage, String name) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setTitle("Шифровка");
        stage.setScene(new Scene(root, 630, 490));
        stage.setResizable(false);
        stage.show();
        }
}
