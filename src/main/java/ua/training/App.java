package ua.training;

import ua.training.controllers.Controller;
import ua.training.models.Model;
import ua.training.views.View;

/**
 * Main class
 */
public class App {

    /**
     * Main method
     * @param args console args
     */
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }

}
