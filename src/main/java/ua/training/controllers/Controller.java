package ua.training.controllers;

import ua.training.models.Model;
import ua.training.views.View;

/**
 * Created by Ivan on 30.10.2016.
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {

    }

}
