package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.view.View;

/**
 * Clase ObserverVelocidad que implementa la interfaz Observer.
 * Esta clase se encarga de observar los cambios en la velocidad de un coche.
 */
public class ObserverVelocidad implements Observer {
    /**
     * Este método es llamado siempre que hay un cambio en la velocidad del coche.
     * El observable cuando hace el notifyObservers 'dispara' todos los update de los Observers.
     *
     * @param arg el argumento pasado por el observable, el coche actualizado
     */
    @Override
    public void update(Coche arg) {
        // Imprime un mensaje con la nueva velocidad del coche
        System.out.println("[ObserverVelocidad] Se ha cambiado la velocidad: " + arg.velocidad.toString() + "km/hr");
        // Le comunica a la vista que muestre la nueva velocidad del coche
        View.muestraVelocidad(arg.matricula, arg.velocidad);
    }
}