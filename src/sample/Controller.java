package sample;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainpanel;

    @FXML
    private Button buttonSendMessage;

    @FXML
    private Button UserSettings;

    @FXML
    private ListView<String> List;

    @FXML
    private ImageView UserSet;

    @FXML
    private TextField InputText;

    @FXML
    private ListView<MessageItem> ChatView;


    @FXML
    private TextArea MessageText;

    @FXML
    private TabPane Panell;

    @FXML
    private ListView<Chats> AllChats;


    @FXML
    private ListView<Chats> ClientChats;

    private Model model;
    private Stage stage;

    @FXML
    void initialize() {


        model = new Model(this);

        createNewTabbledActivity();
        createMessageItem();
        addUserSettingsImage();
        addSendMessageAction();
        setKeyboardAction();


    }
    private void makeToast(String toastMsg,Stage stage){
        int toastMsgTime = 3500; //3.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime= 500; //0.5 seconds
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
    }
    private void addSendMessageAction() {
        this.buttonSendMessage.setOnAction(event -> {
            System.out.println("+");
            System.out.println(MessageText.getText());
            MessageText.setText("");
            checkAuth();
        });
    }
    private void setKeyboardAction() {
        MessageText.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().getName().equals("Enter")) {
                System.out.println(MessageText.getText());
                MessageText.setText("");
                checkAuth();
            }
        });
    }
    private void addUserSettingsImage() {
        File file = new File("src/sample/img/default-user-image.png");
        Image imag = new Image(file.toURI().toString());
        this.UserSet = new ImageView();
        UserSet.setImage(imag);
        UserSet.setFitHeight(40);
        UserSet.setFitWidth(40);
        UserSet.setLayoutX(20);
        UserSet.setLayoutY(5);
        UserSet.setOnMouseClicked(e->{
            System.out.println("Настройки открыты");
            dialogPane();
        });
        mainpanel.getChildren().add(UserSet);
    }
    private void createNewTabbledActivity(){
        TabPane tabPane = new TabPane();

        ArrayList<Chats> chats = new ArrayList<>();
        for (int i =0;i<20;i++){
            chats.add(new Chats(String.valueOf(i)));
        }

        ObservableList<Chats> langs = FXCollections.observableArrayList(chats);

        ClientChats = new ListView<>(langs);
        AllChats = new ListView<>(langs);

        tabPane.setId(String.valueOf(tabPane));

        Tab tab1 = new Tab("Мои чаты", ClientChats);
        Tab tab2 = new Tab("Доступные чаты"  , AllChats);


        tabPane.setMaxWidth(300);
        tab1.setClosable(false);
        tab2.setClosable(false);


        tabPane.getStylesheets().add(Controller.class.getResource("Style.css").toExternalForm());

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.setLayoutX(10);
        tabPane.setLayoutY(50);
        tabPane.setMinHeight(460);


        mainpanel.getChildren().add(tabPane);
    }
    private void dialogPane(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();



        dialog.setTitle("Настройки пользователя");
        dialog.setHeight(500);
        dialog.setWidth(500);
        ButtonType okButton = new ButtonType("Сохранить", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.getDialogPane().getButtonTypes().add(cancelButton);
        Stage stage = (Stage) UserSet.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
            dialog.getDialogPane().setContent(root);

        } catch (IOException e) {
            e.printStackTrace();
        }


        Optional<ButtonType> result = dialog.showAndWait();
        ButtonType button  = result.orElse(ButtonType.CANCEL);


        if (button.getText().equals("Сохранить")) {
            System.out.println("Ok pressed");
        } else {
            System.out.println("canceled");
        }
    }
    private void createMessageItem(){
        java.util.List<MessageItem> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(new MessageItem("Item " + i, "Button " + i));
        }

        ObservableList<MessageItem> myObservableList = FXCollections.observableList(list);
        ChatView.setItems(myObservableList);
        MultipleSelectionModel<MessageItem> langsSelectionModel = ChatView.getSelectionModel();
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<MessageItem>() {
            @Override
            public void changed(ObservableValue<? extends MessageItem> observableValue, MessageItem messageItem, MessageItem t1) {
                System.out.println(t1.user.getText());
            }
        });
    }
    private void checkAuth(){
        if(model.getAuthInfo()){
            //клиент авторизирован
        } else {
            //клиент не авторизирован
            Stage stage = (Stage) UserSet.getScene().getWindow();
            makeToast("Вы не авторизированы, пожалуйста зайдите под своим логином и паролем",stage);
        }
    }
}







