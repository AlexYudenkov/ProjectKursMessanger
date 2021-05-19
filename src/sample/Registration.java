package sample;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Registration {


    @FXML
    private URL location;


    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane mainpane;

    @FXML
    private TextField Nickname;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField SecondPassword;

    @FXML
    private Button createAccount;

    @FXML
    void initialize() {
        createAccount.setOnAction(event -> {
            checkData();
        });
    }

    private void checkData() {
        String user = Nickname.getText();
        String password = Password.getText();
        String secondPassword = Password.getText();
        if(password.equals(secondPassword)){
            System.out.println("Можно запустить");
            Model.makeAuthorization(user,password);
        } else {
            Stage stage = (Stage) Nickname.getScene().getWindow();
            makeToast("Пароли не совпадают",stage);
        }
    }
    private void makeToast(String toastMsg,Stage stage){
        int toastMsgTime = 3500; //3.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime= 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
    }

}
