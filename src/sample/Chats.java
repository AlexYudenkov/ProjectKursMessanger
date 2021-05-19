package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class Chats extends HBox {
    Label name = new Label();

    Chats (String chatName) {
        super();

        name.setText(chatName);
        name.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(name, Priority.ALWAYS);


        this.getChildren().addAll(name);
    }
}