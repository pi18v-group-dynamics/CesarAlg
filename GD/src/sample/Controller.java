package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.scene.paint.Paint;
=======
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


>>>>>>> bfed6783e7e2bfa366fc770cece2c23df4bf5582

public class Controller {
    static char[] alfavitEn=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public TextArea TextAreaOutput;
    public TextArea TextAreaInput;
    public TextField TextFieldKey;
    public Button button1;
    public Button obzor;
    public Button saveas;
    public Label kluch;
    public Button oprogramme;
    public Label razrab;
    public Button rukovodstvo;
    public Button colorshem;
    public Button smenitl;
    public Button button2;
    private boolean count = true;

    public void ButtonLanguage(ActionEvent actionEvent) {
        if(count){
            button1.setText("Encrypt");
        razrab.setText("developer");
        saveas.setText("Save As");
        smenitl.setText("Language");
        colorshem.setText("Color");
        obzor.setText("Select");
        oprogramme.setText("About");
        rukovodstvo.setText("Guide");
        kluch.setText("key");
        button2.setText("Descript");
        count=false;
        }else {
            button1.setText("Зашифровать");
            button2.setText("Расшифровать");
            razrab.setText("Разработчики: ");
            saveas.setText("Сохранить как");
            smenitl.setText("Сменить язык");
            colorshem.setText("Цветовая схема");
            obzor.setText("Обзор");
            oprogramme.setText("О программе");
            rukovodstvo.setText("Руководство");
            kluch.setText("Введите ключ");

            count=true;
        }


    }


    public void ButtonDecrypt(ActionEvent actionEvent) {
        char[] str=TextAreaInput.getText().toLowerCase().toCharArray();
        int j=0;
        for(int i=0;i<TextAreaInput.getText().length();i++){
            if(str[i]==' ' || str[i]=='\n' || str[i]=='.') i++;
            while(alfavitEn[j]!=str[i])
                j++;
            int n=j-Integer.parseInt(TextFieldKey.getText());
            if(n<0)str[i]=alfavitEn[n+26];
            else if(n<alfavitEn.length)
                str[i]=alfavitEn[n];
            j=0;
        }
        TextAreaOutput.setText(String.valueOf(str));
    }

    public void ButtonEncrypt(ActionEvent actionEvent) {
        char[] str=TextAreaInput.getText().toLowerCase().toCharArray();
        int j=0;
        for(int i =0;i<TextAreaInput.getText().length(); i++){
            if(str[i]==' ' || str[i]=='\n' || str[i]=='.') i++;
            while(alfavitEn[j]!=str[i])
                j++;
            int n=j+Integer.parseInt(TextFieldKey.getText());
            if(n<alfavitEn.length)
                str[i]=alfavitEn[n];
            else str[i]=alfavitEn[n-26];
            j=0;
        }
        TextAreaOutput.setText(String.valueOf(str));
    }

    public void ButtonSelect(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file=fileChooser.showOpenDialog(new Stage());
        Path path = Paths.get(file.getAbsolutePath());
        TextAreaInput.setText(new String(Files.readAllBytes(path)));
    }

    public void ButtonSaveAs(ActionEvent actionEvent) {
    }

    public void ButtonAbout(ActionEvent actionEvent) {
    }

    public void ButtonHowTo(ActionEvent actionEvent) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Руководство.txt");
        pb.start();
    }


    public void ButtonColorSheme(ActionEvent actionEvent) {
    }
}

