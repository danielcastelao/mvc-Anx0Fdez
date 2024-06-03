package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;

/**
 * La clase Controller en la arquitectura MVC.
 * Esta clase es responsable de manejar las solicitudes del usuario y actualizar el modelo.
 */
public class Controller {
    // El modelo que este controlador actualizará
    private Model model;

    /**
     * El constructor para la clase Controller.
     *
     * @param model El modelo que este controlador actualizará.
     */
    public Controller(Model model) {
        this.model = model;
    }

    /**
     * Busca un coche usando su matrícula.
     *
     * @param matricula La matrícula del coche a buscar.
     * @return El coche con la matrícula dada, o null si no existe tal coche.
     */
    public Coche buscarCoche(String matricula) {
        return model.getCoche(matricula);
    }

    /**
     * Crea un coche con el modelo y matrícula dados.
     *
     * @param modelo    El modelo del coche a crear.
     * @param matricula La matrícula del coche a crear.
     * @return El coche que se creó.
     */
    public Coche crearCoche(String modelo, String matricula) {
        return model.crearCoche(modelo, matricula);
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula La matrícula del coche cuya velocidad se va a cambiar.
     * @param v         La nueva velocidad del coche.
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        model.cambiarVelocidad(matricula, v, model);
    }
}
