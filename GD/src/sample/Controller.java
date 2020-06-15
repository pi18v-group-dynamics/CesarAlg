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
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;




public class Controller {
    static char[] alfavitEn = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] alfavitRu = new char[]{'а', 'б', 'в', 'г', 'д', 'ё',  'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
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
    private boolean countPain = true;
    private boolean textcount = false;
    Pattern en = Pattern.compile("[a-z]*");
    Pattern ru = Pattern.compile("[а-я]*");

    @FXML
    private void method() {

        Pattern p = Pattern.compile("[0-9]*");
        TextFieldKey.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) TextFieldKey.setText(oldValue);
        });
    }


    public void ButtonLanguage(ActionEvent actionEvent) throws IOException {
        if (count) {
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
            Exit.setText("Exit");
            log.setText("Logs");
            count = false;
        } else {
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
            log.setText("Логи");
            Exit.setText("Выход");
            count = true;
        }
        if(Autorization.IsUser) {
            String text = "gosha изменил язык приложения\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
        else{
            String text = "admin изменил язык приложения\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }

    }


    public TextArea TextAreaLog;
    public AnchorPane AnchorPaneAdmin;


    public void ButtonDecrypt(ActionEvent actionEvent) throws IOException {
        if (TextFieldKey.getText().isEmpty()) {
            FileWriter fw = new FileWriter("Взлом.txt");
            String stroka=new String();

            for (int d=1;d<32;d++){
                String strs=wordCount(TextAreaInput.getText()).toLowerCase();
                char[] str = strs.toCharArray();
                int j = 0;
            for (int i = 0; i < strs.length(); i++) {

                try {

                    if (en.matcher(String.valueOf(str[i])).matches()) {
                        while (alfavitEn[j] != str[i])
                            j++;
                        int n = j - d;
                        if (n < 0) str[i] = alfavitEn[n + alfavitEn.length];
                        else if (n < alfavitEn.length)
                            str[i] = alfavitEn[n];
                    } else {
                        if (ru.matcher(String.valueOf(str[i])).matches()) {
                            while (alfavitRu[j] != str[i])
                                j++;
                            int n = j -d;
                            if (n < 0) str[i] = alfavitRu[n + alfavitRu.length];
                            else if (n < alfavitRu.length)
                                str[i] = alfavitRu[n];
                        }
                    }
                } catch (NumberFormatException e) {

                }

                j = 0;
            }
                fw.write(String.valueOf(str)+" "+d+"\n");
//                fw.flush();
            }


            fw.close();
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Взлом.txt");
            pb.start();
        } else {
            char[] str = TextAreaInput.getText().toLowerCase().toCharArray();
            int j = 0;
            for (int i = 0; i < TextAreaInput.getText().length(); i++) {

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

                j = 0;
            }
            TextAreaOutput.setText(String.valueOf(str));
        }
        if(Autorization.IsUser){
            String text="Никнейм:gosha\nТип доступа:Пользователь\nДействие:Расшифровка\nКоличество символов "+TextAreaInput.getLength()+"\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
        else{
            String text="Никнейм:admin\nТип доступа:Администратор\nДействие:Расшифровка\nКоличество символов "+TextAreaInput.getLength()+"\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
    }

    public void ButtonEncrypt(ActionEvent actionEvent) throws IOException {
        char[] str = TextAreaInput.getText().toLowerCase().toCharArray();
        int j = 0;
        for (int i = 0; i < TextAreaInput.getText().length(); i++) {
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
            } catch (Exception e) {
            }
            j = 0;
        }
        TextAreaOutput.setText(String.valueOf(str));
        if(Autorization.IsUser){
            String text="Никнейм:gosha\nТип доступа:Пользователь\nДействие:Зашифровка\nКоличество символов "+TextAreaInput.getLength()+"\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
        else{
            String text="Никнейм:admin\nТип доступа:Администратор\nДействие:Зашифровка\nКоличество символов "+TextAreaInput.getLength()+"\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
    }

    public void ButtonSelect(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(new Stage());
        Path path = Paths.get(file.getAbsolutePath());

        TextAreaInput.setText(new String(Files.readAllBytes(path)));
    }

    public void ButtonSaveAs(ActionEvent actionEvent) throws IOException {
        FileChooser f = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
        f.getExtensionFilters().add(extFilter);
        File file = f.showSaveDialog(new Stage());
        RandomAccessFile r = new RandomAccessFile(file.getAbsolutePath(), "rw");
        byte[] bytes = TextAreaOutput.getText().getBytes();
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


    public void ButtonColorSheme(ActionEvent actionEvent) throws IOException {
        if (countPain) {
            mainPane.getStylesheets().clear();
            pane1.setStyle("-fx-background-color: #2C2B2C");

            pane2.setStyle("-fx-background-color: #2C2B2C");

            mainPane.getStylesheets().add("style.css");
            countPain = false;
        } else {
            pane1.setStyle("-fx-background-color: #F5F4F6");

            pane2.setStyle("-fx-background-color: #F5F4F6");

            mainPane.getStylesheets().clear();

            countPain = true;
        }
        if(Autorization.IsUser) {
            String text = "gosha изменил цветовую схему\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
        else{
            String text = "admin изменил цветовую схему\n\n";
            Files.write(Paths.get("Логи.txt"), text.getBytes(), StandardOpenOption.APPEND);
        }
    }

    public void ButtonLogFile(ActionEvent actionEvent) throws IOException {
        TextAreaLog.clear();
        Path path = Paths.get("Логи.txt");
        Scanner scanner = new Scanner(path);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            TextAreaLog.appendText(line+"\n");
        }
        scanner.close();
    }

    public void ButtonLogOpen(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(true);
    }

    public void ButtonBack(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(false);
    }


    public void ButtonExit(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

    private String wordCount(String str) {
        char[] strok = str.toCharArray();
        int k=0;
        String result=new String();
        for (int i = 0; i < str.length(); i++) {
            result=result.concat(String.valueOf(strok[i]));
            if (strok[i] == ' ') {
                while (strok[i] == ' ')
                    i++;
                i--;
                k++;
            }
            if(k==5){
                break;
            }

        }
//        if(!(strok[str.length()-1]==' ')){
//            k++;
//        }
        return result;
    }
}

