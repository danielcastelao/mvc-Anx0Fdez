package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Model;
import cod.mvc.view.View;

public class App {
    public static void main(String[] args) {
        // Creamos algunos coches
        Model.crearCoche("123ABC", "Seat Ibiza", 0);
        Model.crearCoche("456DEF", "Volkswagen Golf", 0);
        Model.crearCoche("789GHI", "Ford Fiesta", 0);

        // Cambiamos la velocidad de algunos coches
        Model.cambiarVelocidad("123ABC", 50);
        Model.cambiarVelocidad("456DEF", 60);
        Model.cambiarVelocidad("789GHI", 70);

        // Obtenemos y mostramos la velocidad de cada coche
        View.muestraVelocidad("123ABC", Model.getVelocidad("123ABC"));
        View.muestraVelocidad("456DEF", Model.getVelocidad("456DEF"));
        View.muestraVelocidad("789GHI", Model.getVelocidad("789GHI"));
    }
}
