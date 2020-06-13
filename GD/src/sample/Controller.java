package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
    static char[] alfavitEn=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public TextArea TextAreaOutput;
    public TextArea TextAreaInput;
    public TextField TextFieldKey;
    public TextArea TextAreaLog;
    public AnchorPane AnchorPaneAdmin;

    public void ButtonDecrypt(ActionEvent actionEvent) {
        char[] str=TextAreaInput.getText().toLowerCase().toCharArray();
        int j=0;
        for(int i=0;i<TextAreaInput.getText().length();i++){
            if(str[i]==' ') i++;
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
            if(str[i]==' ') i++;
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

    public void ButtonSelect(ActionEvent actionEvent) {
    }

    public void ButtonSaveAs(ActionEvent actionEvent) {
    }

    public void ButtonAbout(ActionEvent actionEvent) {
    }

    public void ButtonHowTo(ActionEvent actionEvent) {
    }

    public void ButtonLanguage(ActionEvent actionEvent) {
    }

    public void ButtonColorSheme(ActionEvent actionEvent) {
    }

    public void ButtonLogFile(ActionEvent actionEvent) {
    }

    public void ButtonLogOpen(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(true);
    }

    public void ButtonBack(ActionEvent actionEvent) {
        AnchorPaneAdmin.setVisible(false);
    }
}

