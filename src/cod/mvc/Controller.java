package cod.mvc;

public class Controller {
    private static Model model = new Model();
    private static View view = new View();

    public static void main(String[] args) {
        // Creamos algunos coches
        model.crearCoche("123ABC", "Seat Ibiza", 0);
        model.crearCoche("456DEF", "Volkswagen Golf", 0);
        model.crearCoche("789GHI", "Ford Fiesta", 0);

        // Cambiamos la velocidad de algunos coches
        model.cambiarVelocidad("123ABC", 50);
        model.cambiarVelocidad("456DEF", 60);
        model.cambiarVelocidad("789GHI", 70);

        // Obtenemos y mostramos la velocidad de cada coche
        view.muestraVelocidad("123ABC", model.getVelocidad("123ABC"));
        view.muestraVelocidad("456DEF", model.getVelocidad("456DEF"));
        view.muestraVelocidad("789GHI", model.getVelocidad("789GHI"));
    }
}