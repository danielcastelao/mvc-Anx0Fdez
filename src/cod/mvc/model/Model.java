package cod.mvc.model;

import cod.mvc.controller.Observer;

import java.util.ArrayList;

public class Model implements Observable {
    private static ArrayList<Coche> parking = new ArrayList<>();

    public static void crearCoche(String matricula, String modelo, int velocidad) {
        Coche coche = new Coche(matricula, modelo, velocidad);
        parking.add(coche);
    }

    public static Coche getCoche(String matricula) {
        for (Coche coche : parking) {
            if (coche.getMatricula().equals(matricula)) {
                return coche;
            }
        }
        return null;
    }
    public static void cambiarVelocidad(String matricula, int velocidad) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.setVelocidad(velocidad);
        }
    }

    public static int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            return coche.getVelocidad();
        }
        return -1;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(Coche coche) {

    }
}