package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

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
    private TextField NicknameForAuth;

    @FXML
    private PasswordField PasswordForAuth;

    @FXML
    private Button AuthButton;


    private Model model;
    @FXML
    void initialize() {
        Context.getInstance().setFontController(this);
        model = Context.getInstance().getModel();
        createAccount.setOnAction(event -> {
            checkDataForRegister();
        });
        AuthButton.setOnAction(event -> {
            checkDataForAuth();
        });
    }

    private void checkDataForAuth() {
        String user = NicknameForAuth.getText();
        String password = PasswordForAuth.getText();
        model.autentification(user,password);
    }

    private void checkDataForRegister() {
        String user = Nickname.getText();
        String password = Password.getText();
        String secondPassword = Password.getText();
        if(password.equals(secondPassword)){
            System.out.println("Можно запустить");
            //model.makeAuthorization(user,password);
            model.registerUser(user,password);
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
