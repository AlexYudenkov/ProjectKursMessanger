package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket socket;
    private OutputStreamWriter writer;
    private BufferedReader reader;

    private static final String auth = "<auth";// аутентификация
    private static final String authResult =  "<authresult"; // результат аутентификации
    private static final String sendMessage = "<sendmessage";
    private static final String register = "<register";
    private static final String registerResult = "<registerresult";
    private static final String makeChat = "<makechat";
    private static final String deleteChat = "<deletechat";
    private static final String joinChat = "<joinchat";
    private static final String leave = "<leave";



    public Client(){
        try {
            socket = new Socket("127.0.0.1", 4250);
            writer = new OutputStreamWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(IOException e) {e.printStackTrace();}
    }


    public ArrayList<String> getClients() throws IOException {
        ArrayList<String> users = new ArrayList<>();

        writer.write("userList\n");
        writer.flush();

        int usersAmount = reader.read();
        for (int i = 0; i < usersAmount; i++) {
            users.add(reader.readLine());
        }

        return users;
    }

    public void close(){
        try {
            if(writer != null) {
                writer.write("Exit\n");
                writer.flush();
                socket.close();
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //отправка запроса на регистрацию пользователя
    public void registerUser(String registerFullInfo) {
        String finalRequest = register + "." + registerFullInfo + ".register>";
        try {
            writer.write(finalRequest+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //отправка запроса на аутетификацию
    public void authorization(String user, String password) {
        String finalRequest = auth + "." + user + "." + password + ".auth>\n";
        try {
            writer.write(finalRequest);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}