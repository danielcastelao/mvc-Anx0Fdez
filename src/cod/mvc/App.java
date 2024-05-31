package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import cod.mvc.view.View;

public class App {
    public static void main(String[] args) {
        Model miModel = Model.getInstance();
        Controller miController = new Controller(miModel);

        String[] datosCoche = View.solicitarDatosCoche();
        miController.crearCoche(datosCoche[0], datosCoche[1]);

        Coche coche = miController.buscarCoche(datosCoche[1]);
        View.mostrarCoche(coche);
    }
}