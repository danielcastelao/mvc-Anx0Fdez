package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import cod.mvc.view.View;

public class Controller {

    private final Model miModel;

    public Controller(Model miModel){
        this.miModel = miModel;

        // instanciamos al observador de la velocidad
        ObsVelocidad observoVelocidad = new ObsVelocidad();
        miModel.addObserver(observoVelocidad);

        // instanciamos un segundo observador para el limite de velocidad
        ObsVelocidad observoLimite = new ObsVelocidad();
        miModel.addObserver(observoLimite);
    }

    public void crearCoche(String nombre, String matricula){
        miModel.crearCoche(nombre, matricula);
    }
}