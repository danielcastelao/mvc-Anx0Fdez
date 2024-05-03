import java.util.ArrayList;

public class Model {
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