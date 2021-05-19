import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private OutputStreamWriter writer;
    private ArrayList<Socket> clients;
    private ArrayList<ClientHandler> handlers;
    private static final String auth = "<auth";// аутентификация
    private static final String authResult =  "<authresult"; // результат аутентификации
    private static final String sendMessage = "<sendmessage";
    private static final String register = "<register";
    private static final String registerResult = "<registerresult";
    private static final String makeChat = "<makechat";
    private static final String deleteChat = "<deletechat";
    private static final String joinChat = "<joinchat";
    private static final String leave = "<leave";

    public ClientHandler(ArrayList<Socket> clients)
    {
        this.socket = clients.get(clients.size()-1);
        try {
            writer = new OutputStreamWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clients = clients;
    }

    private void checkRequest(String request) {
        String[] subStr;
        subStr = request.split("\\.");
        System.out.println(request);
        switch (subStr[0]){
            case auth:
                makeAuth(request);
                break;
            case sendMessage:
                arrivedMessage(request);
                break;
            case register:
                registerUser(request);
                break;
            case makeChat:
                MakeChat(request);
                break;
            case deleteChat:
                DeleteChat(request);
                break;
            case joinChat:
                JoinChat(request);
                break;
            default:

                break;
        }
    }



    @Override
    public void run() {
        System.out.println("начали");
        while(true) {
            try {
               String request = reader.readLine();
               checkRequest(request);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }






    private void JoinChat(String joinInfo) {
        System.out.println("joinchat");
    }

    private void DeleteChat(String delInfo) {
        System.out.println("delchat");
    }

    private void MakeChat(String chatInfo) {
        System.out.println("makechat");
    }

    private void registerUser(String userRegister) {
        System.out.println("register user");
        String[] subStr;
        subStr = userRegister.split("\\.");
        System.out.println(subStr[1]);//имя пользователя
        System.out.println(subStr[2]);//пароль
    }

    private void arrivedMessage(String message) {
        System.out.println("message arrive");
    }

    private void makeAuth(String authcode) {
        System.out.println("auth");
    }

}
