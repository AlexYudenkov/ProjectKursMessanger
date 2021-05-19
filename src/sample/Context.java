package sample;

public class Context {
    private final static Context instance = new Context();
    public static Context getInstance() {
        return instance;
    }


    private Controller controller;
    public void setController(Controller controller) {
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }

    private Registration registration;
    public void setFontController(Registration registration) {
        this.registration=registration;
    }

    public Registration getFontController() {
        return registration;
    }
    private Model model;
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }




}
