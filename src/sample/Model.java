package sample;

import sample.Controller;
import sample.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {
    
    Controller controller;
    Person person;
    Client connect;
    
    public Model(Controller controller){
        this.controller = controller;
        person = new Person("user");
        connect = new Client();
        Context.getInstance().setModel(this);
    }

    public boolean  getAuthInfo(){
        if (person.isAuthorized()) {
            return true;
        } else {
            return false;
        }
    }


    public boolean setAuthorization(){
        if (person.isAuthorized()) {
            return false;
        } else {
            connect.getAuthorization();
            return true;
        }
    }

    public void registerUser(String userName, String Password){
        String registerFullInfo = userName+"."+Password;
        connect.registerUser(registerFullInfo);
    }

    //авторизация пользователя
    public void makeAuthorization(String name, String password){
        System.out.println(name);
        System.out.println(password);
        connect.getAuthorization();
    }
    public void serverConnect(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {



                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }
    
}
