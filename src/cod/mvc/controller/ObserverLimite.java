package cod.mvc.controller;

import cod.mvc.model.Coche;

/**
 * Clase ObserverLimite que implementa la interfaz Observer.
 * Esta clase se encarga de observar los cambios en la velocidad de un coche y verificar si supera un límite establecido.
 */
public class ObserverLimite implements Observer {
    // Velocidad máxima permitida
    final static int LIMITE = 120;

    /**
     * Este es el observador de limite de velocidad.
     * @param coche Coche al que se le actualizó la velocidad
     */
    @Override
    public void update(Coche coche) {
        // Verifica si la velocidad del coche supera el límite
        if (coche.velocidad > LIMITE) {
            // Imprime un mensaje de infracción si la velocidad supera el límite
            System.out.println("[ObserverLimite] INFRACCION");
        }
    }
}