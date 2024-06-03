import cod.mvc.controller.Observer;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Model class.
 */
public class ModelTest {
    private Model model;
    private Coche coche;

    /**
     * This method sets up the testing environment before each test.
     * It creates an instance of Model and a Coche object.
     */
    @BeforeEach
    public void setup() {
        model = Model.getInstance();
        coche = model.crearCoche("Modelo1", "ABC123");
    }

    /**
     * This test checks if the crearCoche method creates a new car correctly.
     */
    @Test
    public void crearCoche_createsNewCar() {
        Coche newCoche = model.crearCoche("Modelo2", "DEF456");
        assertNotNull(newCoche);
        assertEquals("Modelo2", newCoche.modelo);
        assertEquals("DEF456", newCoche.matricula);
    }

    /**
     * This test checks if the getCoche method returns an existing car correctly.
     */
    @Test
    public void getCoche_returnsExistingCar() {
        Coche existingCoche = Model.getCoche("ABC123");
        assertNotNull(existingCoche);
        assertEquals("Modelo1", existingCoche.modelo);
        assertEquals("ABC123", existingCoche.matricula);
    }

    /**
     * This test checks if the getCoche method returns null for a non-existing car.
     */
    @Test
    public void getCoche_returnsNullForNonExistingCar() {
        Coche nonExistingCoche = Model.getCoche("XYZ789");
        assertNull(nonExistingCoche);
    }

    /**
     * This test checks if the cambiarVelocidad method increases the speed of a car correctly.
     */
    @Test
    public void cambiarVelocidad_increasesSpeed() {
        Integer newSpeed = Model.cambiarVelocidad("ABC123", 50, model);
        assertNotNull(newSpeed);
        assertEquals(50, newSpeed);
    }

    /**
     * This test checks if the cambiarVelocidad method decreases the speed of a car correctly.
     */
    @Test
    public void cambiarVelocidad_decreasesSpeed() {
        Model.cambiarVelocidad("ABC123", 50, model);
        Integer newSpeed = Model.cambiarVelocidad("ABC123", 30, model);
        assertNotNull(newSpeed);
        assertEquals(30, newSpeed);
    }

    /**
     * This test checks if the cambiarVelocidad method returns null for a non-existing car.
     */
    @Test
    public void cambiarVelocidad_returnsNullForNonExistingCar() {
        Integer newSpeed = Model.cambiarVelocidad("XYZ789", 50, model);
        assertNull(newSpeed);
    }
}