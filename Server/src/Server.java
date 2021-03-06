import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ArrayList<Socket> clients = new ArrayList<>();

        try{
            ServerSocket servSocket = new ServerSocket(4250);
            System.out.println("Started!");

            while (!servSocket.isClosed()) {
                System.out.println("работает");
                Socket client = servSocket.accept();
                System.out.println("Connect! " + client.getInetAddress().getHostAddress() + ' ' + client.getPort() + ' ' + clients.size());

                clients.add(client);

                ClientHandler thread = new ClientHandler(clients);
                thread.start();
            }
        } catch(Exception e){ e.printStackTrace(); }
    }
}
