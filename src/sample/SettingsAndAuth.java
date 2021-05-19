package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsAndAuth {

    Label user = new Label();
    Label Message = new Label();

    public SettingsAndAuth(Stage primaryStage) throws IOException {
        super();
        user.setText("Имя");
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 620, 600));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
