package sample;

import sample.Controller;
import sample.Person;

import java.io.IOException;

public final class Model {
    
    Controller controller;
    Person person;
    Client connect;
    
    public Model(Controller controller){
        this.controller = controller;
        person = new Person("user");
        connect = new Client();
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
            //авторизация
            return true;
        }
    }

    public static void makeAuthorization(String name, String password){
        //отправка на сервер
        System.out.println(name);
        System.out.println(password);
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
