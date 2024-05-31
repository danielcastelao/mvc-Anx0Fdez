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

}