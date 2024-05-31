package cod.mvc.view;

import cod.mvc.model.Coche;
import java.util.Scanner;

/**
 * La clase View en la arquitectura MVC.
 * Esta clase es responsable de todas las interacciones con el usuario.
 */
public class View {

    /**
     * Muestra la velocidad de un coche dado su matrícula y velocidad.
     * @param matricula La matrícula del coche.
     * @param v La velocidad del coche.
     * @return true después de mostrar exitosamente la velocidad.
     */
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("[View] " + matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra los detalles de un coche.
     * @param coche El objeto coche cuyos detalles se van a mostrar.
     */
    public static void mostrarCoche(Coche coche) {
        System.out.println("[View] Modelo: " + coche.modelo + ", Matricula: " + coche.matricula + ", Velocidad: " + coche.velocidad + "km/hr");
    }

    /**
     * Solicita al usuario que introduzca los detalles de un coche.
     * @return Un array que contiene el modelo y la matrícula del coche.
     */
    public static String[] solicitarDatosCoche() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el modelo del coche:");
        String modelo = scanner.nextLine();
        System.out.println("Introduce la matrícula del coche:");
        String matricula = scanner.nextLine();
        return new String[]{modelo, matricula};
    }
}