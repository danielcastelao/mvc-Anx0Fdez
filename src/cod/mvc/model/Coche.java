package cod.mvc.model;

/**
 * La clase Coche representa un coche en la aplicación.
 * Contiene la matrícula del coche, el modelo y la velocidad.
 */
public class Coche {
    // La matrícula del coche
    public String matricula;
    // El modelo del coche
    public String modelo;
    // La velocidad del coche
    public Integer velocidad;

    /**
     * El constructor para la clase Coche.
     * @param modelo El modelo del coche.
     * @param matricula La matrícula del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}