import cod.mvc.controller.Controller;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerTest {
    private Controller controller;
    private Model model;

    @BeforeEach
    public void setup() {
        model = new Model();
        controller = new Controller(model);
    }

    @Test
    public void createsCarWithGivenNameAndMatricula() {
        controller.crearCoche("TestCar", "1234");
        Coche coche = model.getCoche("1234");
        assertNotNull(coche);
        assertEquals("TestCar", coche.modelo);
        assertEquals("1234", coche.matricula);
    }



    }

    /*@Test
    public void doesNotChangeSpeedOfNonExistentCar() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.cambiarVelocidad("1234", 50);
        });
    }

    @Test
    public void doesNotCreateCarWithDuplicateMatricula() {
        controller.crearCoche("TestCar", "1234");
        assertThrows(IllegalArgumentException.class, () -> {
            controller.crearCoche("AnotherCar", "1234");
        });
    }
    */
}