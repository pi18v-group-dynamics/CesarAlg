package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;



import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;




public class Controller {
    static char[] alfavitEn=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static char[] alfavitRu=new char[]{'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
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
    public Button copy;
    public AnchorPane mainPane;
    public AnchorPane pane2;
    public AnchorPane pane1;
    public Button log;
    public Button Exit;
    private boolean count = true;
    private boolean countPain=true;
    private boolean textcount=false;
    Pattern en = Pattern.compile("[a-z]*");
    Pattern ru = Pattern.compile("[а-я]*");
    @FXML
    private void method(){

        Pattern p = Pattern.compile("[0-9]*");
        TextFieldKey.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) TextFieldKey.setText(oldValue);
        });
    }


    public void ButtonLanguage(ActionEvent actionEvent) {
        if(count){
            button1.setText("Encrypt");
        razrab.setText("Developers: ");
        saveas.setText("Save as");
        smenitl.setText("Language");
        colorshem.setText("Color Scheme");
        obzor.setText("Select");
        oprogramme.setText("About");
        rukovodstvo.setText("Guide");
        kluch.setText("Enter the key");
        button2.setText("Decrypt");
        copy.setText("Copy");
Exit.setText("Exit");
        log.setText("Logs");
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
            copy.setText("Копировать");
            log.setText("Логи");
            Exit.setText("Выход");
            count=true;
        }


    }


    public TextArea TextAreaLog;
    public AnchorPane AnchorPaneAdmin;


    public void ButtonDecrypt(ActionEvent actionEvent) throws IOException{
        if(TextFieldKey.getText().isEmpty())
        { FileWriter fw = new FileWriter("Взлом.txt");
            //fw.write(var);
            fw.flush();
            fw.close();
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Взлом.txt");
            pb.start();
       }else{
        char[] str=TextAreaInput.getText().toLowerCase().toCharArray();
        int j=0;
        for(int i=0;i<TextAreaInput.getText().length();i++){

            try {

                if (en.matcher(String.valueOf(str[i])).matches()) {
                    while (alfavitEn[j] != str[i])
                        j++;
                    int n = j - Integer.parseInt(TextFieldKey.getText());
                    if (n < 0) str[i] = alfavitEn[n + alfavitEn.length];
                    else if (n < alfavitEn.length)
                        str[i] = alfavitEn[n];
                } else {
                    if (ru.matcher(String.valueOf(str[i])).matches()) {
                        while (alfavitRu[j] != str[i])
                            j++;
                        int n = j - Integer.parseInt(TextFieldKey.getText());
                        if (n < 0) str[i] = alfavitRu[n + alfavitRu.length];
                        else if (n < alfavitRu.length)
                            str[i] = alfavitRu[n];
                    }
                }
            } catch (NumberFormatException e) {

            }

            j=0;}
        TextAreaOutput.setText(String.valueOf(str));
    }
    }

    public void ButtonEncrypt(ActionEvent actionEvent) {
        char[] str=TextAreaInput.getText().toLowerCase().toCharArray();
        int j=0;
        for(int i =0;i<TextAreaInput.getText().length(); i++){
//            if(str[i]==' ' || str[i]=='\n' || str[i]=='.') i++;
try {
    if (en.matcher(String.valueOf(str[i])).matches()) {
        while (alfavitEn[j] != str[i])
            j++;
        int n = j + Integer.parseInt(TextFieldKey.getText());
        if (n < alfavitEn.length)
            str[i] = alfavitEn[n];
        else str[i] = alfavitEn[n - alfavitEn.length];
    } else {
        if (ru.matcher(String.valueOf(str[i])).matches()) {
            while (alfavitRu[j] != str[i])
                j++;
            int n = j + Integer.parseInt(TextFieldKey.getText());
            if (n < alfavitRu.length)
                str[i] = alfavitRu[n];
            else str[i] = alfavitRu[n - alfavitRu.length];
        }
    }
}catch (Exception e){}
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

    public void ButtonSaveAs(ActionEvent actionEvent) throws IOException {
        FileChooser f = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
        f.getExtensionFilters().add(extFilter);
        File file=f.showSaveDialog(new Stage());
        RandomAccessFile r = new RandomAccessFile(file.getAbsolutePath(), "rw");
        byte[] bytes= TextAreaOutput.getText().getBytes();
        r.writeBytes(TextAreaOutput.getText());
    }

    public void ButtonAbout(ActionEvent actionEvent) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Опрограмме.txt");
        pb.start();
    }

    public void ButtonHowTo(ActionEvent actionEvent) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Руководство.txt");
        pb.start();
    }


    public void ButtonColorSheme(ActionEvent actionEvent) {
        if (countPain){
            mainPane.getStylesheets().clear();
            pane1.setStyle("-fx-background-color: #2C2B2C");

            pane2.setStyle("-fx-background-color: #2C2B2C");

            mainPane.getStylesheets().add("style.css");
            countPain=false;
        }else{
            pane1.setStyle("-fx-background-color: #F5F4F6");

            pane2.setStyle("-fx-background-color: #F5F4F6");

            mainPane.getStylesheets().clear();

            countPain=true;
        }
    }

    public void ButtonLogFile(ActionEvent actionEvent) {
    }

    public void ButtonLogOpen(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(true);
    }

    public void ButtonBack(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(false);
    }



    public void ButtonExit(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}

