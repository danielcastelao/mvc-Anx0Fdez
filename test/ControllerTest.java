import cod.mvc.controller.Controller;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Esta clase contiene pruebas unitarias para la clase Controller.
 */
public class ControllerTest {
    private Controller controller;
    private Model model;

    /**
     * Este método configura los objetos necesarios para las pruebas.
     * Se ejecuta antes de cada prueba.
     */
    @BeforeEach
    public void setup() {
        model = new Model();
        controller = new Controller(model);
    }

    /**
     * Esta prueba verifica si se crea un coche con el nombre y matrícula dados.
     */
    @Test
    public void creaCocheConNombreYMatriculaDados() {
        controller.crearCoche("TestCar", "1234");
        Coche coche = model.getCoche("1234");
        assertNotNull(coche);
        assertEquals("TestCar", coche.modelo);
        assertEquals("1234", coche.matricula);
    }

    /**
     * Esta prueba verifica si la velocidad del coche cambia correctamente.
     */
    @Test
    public void cambiaVelocidadDelCoche() {
        controller.crearCoche("TestCar", "1234");
        controller.cambiarVelocidad("1234", 50);
        Coche coche = model.getCoche("1234");
        assertEquals(50, coche.velocidad);
    }

    /**
     * Esta prueba verifica si la velocidad del coche cambia correctamente y si excede el límite.
     * También verifica si se imprime la salida correcta cuando se excede el límite de velocidad.
     */
    @Test
    public void cambiaVelocidadDelCocheYExcedeLimite() {

        // Redirige la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.crearCoche("TestCocheRapido", "BX5555");
        controller.cambiarVelocidad("BX5555", 150);
        Coche coche = model.getCoche("BX5555");
        assertEquals(150, coche.velocidad);

        // Verifica la salida
        String salidaEsperada = "[ObserverVelocidad] Se ha cambiado la velocidad: 150km/hr\n" +
                "[View] BX5555: 150km/hr\n" + "[ObserverLimite] INFRACCION\n";
        assertEquals(salidaEsperada, outContent.toString());
    }
}