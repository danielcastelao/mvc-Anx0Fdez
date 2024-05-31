package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Model;

/**
 * Clase principal
 */
public class App {

    public static void main(String[] args) {
        // Inicializamos la app
        // instanciamos el modelo
        // instanciamos el model
        Model miModel = Model.getInstance();
        // le pasamos el Model instanciado
        Controller miController = new Controller(miModel);

        // Crear tres coches
        miController.crearCoche("LaFerrari", "SBC 1234");
        miController.crearCoche("Alpine", "HYU 4567");
        miController.crearCoche("Aston Martin", "FGH 3333");

        // Cambiar la velocidad de un coche
        miController.cambiarVelocidad("SBC 1234", 30);

        // otro cambio de velocidad
        // sobrepasando la velocidad máxima
        miController.cambiarVelocidad("HYU 4567", 150);

    }
}
