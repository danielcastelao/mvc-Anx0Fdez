package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public Coche buscarCoche(String matricula) {
        return model.getCoche(matricula);
    }

}