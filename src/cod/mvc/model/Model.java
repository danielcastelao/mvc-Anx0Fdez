package cod.mvc.model;

import cod.mvc.controller.Observer;
import java.util.ArrayList;

public class Model implements Observable {
    static ArrayList<Coche> parking = new ArrayList<>();
    private static final ArrayList<Observer> observers = new ArrayList<Observer>();
    private static Model instance = null;

    private Model() {}

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Coche coche) {
        for (Observer observer : observers) {
            observer.update(coche);
        }
    }

    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    public static Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    public static Integer cambiarVelocidad(String matricula, int velocidad, Model model) {
        Coche c = getCoche(matricula);
        if (c != null) {
            if (c.velocidad > velocidad) {
                bajarVelocidad(matricula, c.velocidad - velocidad, model);
            } else {
                subirVelocidad(matricula, velocidad + c.velocidad, model);
            }
            model.notifyObservers(c);
            return velocidad;
        }
        return null;
    }



    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}