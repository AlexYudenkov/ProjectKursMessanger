package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class MessageItem extends HBox {
    Label user = new Label();
    Label Message = new Label();

    MessageItem(String userName, String MessageText) {
        super();

        userName = userName + "пишет:";

        Message.setText(MessageText);
        Message.setAlignment(Pos.CENTER_RIGHT);

        user.setText(userName);
        user.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(user, Priority.ALWAYS);

        user.setId("user");

        user.getStylesheets().add(Controller.class.getResource("Style.css").toExternalForm());

        this.getChildren().addAll(user,Message);
    }
}

