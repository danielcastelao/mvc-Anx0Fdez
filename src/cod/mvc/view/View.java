package cod.mvc.view;

import cod.mvc.model.Coche;

import java.util.Scanner;

public class View {
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("[View] " + matricula + ": " + v + "km/hr");
        return true;
    }

    public static void mostrarCoche(Coche coche) {
        System.out.println("[View] Modelo: " + coche.modelo + ", Matricula: " + coche.matricula + ", Velocidad: " + coche.velocidad + "km/hr");
    }
    public static String[] solicitarDatosCoche() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el modelo del coche:");
        String modelo = scanner.nextLine();
        System.out.println("Introduce la matrícula del coche:");
        String matricula = scanner.nextLine();
        return new String[]{modelo, matricula};
    }

}