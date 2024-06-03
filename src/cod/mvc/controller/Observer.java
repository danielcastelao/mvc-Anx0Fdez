package cod.mvc.controller;

import cod.mvc.model.Coche;

/**
 * Interfaz Observer.
 * Define el método update que se ejecutará cuando el objeto observado (un coche) cambie.
 */
public interface Observer {
    /**
     * Método que se ejecutará cuando el objeto observado cambie.
     * @param arg el coche que ha cambiado
     */
    void update(Coche arg);
}