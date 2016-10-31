package ua.training;

import ua.training.controllers.Controller;
import ua.training.models.Model;
import ua.training.views.View;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }

}
