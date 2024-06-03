package cod.mvc.model;

import cod.mvc.controller.Observer;
import java.util.ArrayList;

/**
 * Clase Model que implementa la interfaz Observable.
 * Esta clase representa el modelo en el patrón MVC y es responsable de gestionar los datos de la aplicación.
 */
public class Model implements Observable {
    static ArrayList<Coche> parking = new ArrayList<>(); // Lista de objetos Coche que representan un estacionamiento.
    private static final ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores a notificar de los cambios.
    private static Model instance = null; // Instancia singleton de la clase Model.

    // Constructor privado para prevenir la instanciación.
    private Model() {}

    /**
     * Método para obtener la instancia singleton de la clase Model.
     * @return la instancia singleton de la clase Model.
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    /**
     * Método para añadir un observador a la lista de observadores.
     * @param observer el observador a añadir.
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Método para eliminar un observador de la lista de observadores.
     * @param observer el observador a eliminar.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Método para notificar a todos los observadores de un cambio en un objeto Coche.
     * @param coche el objeto Coche que ha cambiado.
     */
    @Override
    public void notifyObservers(Coche coche) {
        for (Observer observer : observers) {
            observer.update(coche);
        }
    }

    /**
     * Método para crear un nuevo objeto Coche y añadirlo a la lista de estacionamiento.
     * @param modelo el modelo del nuevo Coche.
     * @param matricula la matrícula del nuevo Coche.
     * @return el nuevo objeto Coche.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Método para obtener un objeto Coche de la lista de estacionamiento por su matrícula.
     * @param matricula la matrícula del Coche a recuperar.
     * @return el objeto Coche con la matrícula dada, o null si no existe tal Coche.
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Método para cambiar la velocidad de un objeto Coche.
     * Si la nueva velocidad es menor que la velocidad actual, la velocidad se reduce.
     * Si la nueva velocidad es mayor que la velocidad actual, la velocidad se incrementa.
     * @param matricula la matrícula del Coche a cambiar.
     * @param velocidad la nueva velocidad del Coche.
     * @param model la instancia de Model.
     * @return la nueva velocidad del Coche, o null si no existe tal Coche.
     */
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

    /**
     * Método para aumentar la velocidad de un objeto Coche.
     * @param matricula la matrícula del Coche a cambiar.
     * @param v la cantidad por la que se debe aumentar la velocidad.
     * @param model la instancia de Model.
     * @return la nueva velocidad del Coche, o null si no existe tal Coche.
     */
    public static Integer subirVelocidad(String matricula, int v, Model model) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad += v;
            model.notifyObservers(getCoche(matricula));
            return c.velocidad;
        }
        return null;
    }

    /**
     * Método para disminuir la velocidad de un objeto Coche.
     * @param matricula la matrícula del Coche a cambiar.
     * @param v la cantidad por la que se debe disminuir la velocidad.
     * @param model la instancia de Model.
     * @return la nueva velocidad del Coche, o null si no existe tal Coche.
     */
    public static Integer bajarVelocidad(String matricula, int v, Model model) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad -= v;
            model.notifyObservers(getCoche(matricula));
            return c.velocidad;
        }
        return null;
    }

    /**
     * Método para obtener la velocidad de un objeto Coche.
     * @param matricula la matrícula del Coche.
     * @return la velocidad del Coche, o null si no existe tal Coche.
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}