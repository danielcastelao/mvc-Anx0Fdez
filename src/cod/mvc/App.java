package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import cod.mvc.view.View;

/**
 * La clase principal de la aplicación.
 */
public class App {
    /**
     * El método principal de la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Obtiene la única instancia de la clase Model
        Model miModel = Model.getInstance();

        // Crea un nuevo Controller, pasando la instancia del modelo a él
        Controller miController = new Controller(miModel);

        // Llama al método de la View para solicitar los datos del coche al usuario
        String[] datosCoche = View.solicitarDatosCoche();

        // Usa el Controller para crear un nuevo coche con los datos proporcionados por el usuario
        miController.crearCoche(datosCoche[0], datosCoche[1]);

        // Usa el Controller para buscar el coche usando la matrícula proporcionada
        Coche coche = miController.buscarCoche(datosCoche[1]);

        // Usa la View para mostrar los datos del coche
        View.mostrarCoche(coche);
    }
}