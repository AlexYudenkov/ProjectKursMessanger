package sample;

public class Context {
    private final static Context instance = new Context();
    public static Context getInstance() {
        return instance;
    }
    private Model model;
    private Controller controller;
    private Registration registration;
    private Authorization authorization;

    public void setController(Controller controller) {
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setFontController(Registration registration) {
        this.registration=registration;
    }

    public Registration getFontController() {
        return registration;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
