package cod.mvc.model;

import cod.mvc.controller.Observer;
import java.util.ArrayList;

/**
 * La clase Model en la arquitectura MVC.
 * Esta clase es responsable de manejar los datos y la lógica de negocio.
 * Implementa la interfaz Observable para notificar a los observadores de cualquier cambio.
 */
public class Model implements Observable {
    // Array de coches
    static ArrayList<Coche> parking = new ArrayList<>();

    // Para los observadores
    private static final ArrayList<Observer> observers = new ArrayList<Observer>();

    // La única instancia de la clase Model
    private static Model instance = null;

    // Constructor privado
    private Model() {}

    /**
     * Método para obtener la única instancia de la clase Model.
     * Implementa el patrón Singleton.
     * @return La única instancia de la clase Model.
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    /**
     * Añade un observador a la lista de observadores.
     * @param observer El observador a añadir.
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores.
     * @param observer El observador a eliminar.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a los observadores de un cambio.
     * Ejecuta el método update() de cada observador.
     * @param coche El coche que ha cambiado.
     */
    @Override
    public void notifyObservers(Coche coche) {
        for (Observer observer : observers) {
            observer.update(coche);
        }
    }

    /**
     * Crea un coche y lo añade al parking.
     * @param modelo El modelo del coche.
     * @param matricula La matrícula del coche.
     * @return El coche creado.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por su matrícula.
     * @param matricula La matr��cula del coche a buscar.
     * @return El coche encontrado, o null si no se encuentra.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // Recorre el array buscando por matrícula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula La matrícula del coche cuya velocidad se va a cambiar.
     * @param v La nueva velocidad del coche.
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // Busca el coche
        getCoche(matricula).velocidad = v;

        // Notifica a todos los observadores
        notifyObservers(getCoche(matricula));
    }

    /**
     * Devuelve la velocidad de un coche.
     * @param matricula La matrícula del coche cuya velocidad se va a obtener.
     * @return La velocidad del coche.
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}