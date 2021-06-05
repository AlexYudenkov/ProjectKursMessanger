package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Authorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField Nickname;

    @FXML
    private PasswordField Password;

    @FXML
    private Button createAccount;

    @FXML
    void initialize() {
        Nickname.setText("имя пользователя");

    }
}
