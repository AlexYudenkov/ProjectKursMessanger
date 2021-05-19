package sample;

public class Person {

    private String userName;
    private boolean isAuthorized;

    public Person(String userName){
        this.userName = userName;
        isAuthorized = false;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
