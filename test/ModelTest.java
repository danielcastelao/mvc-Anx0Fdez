import cod.mvc.controller.Observer;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    private Model model;
    private Coche coche;

    @BeforeEach
    public void setup() {
        model = Model.getInstance();
        coche = model.crearCoche("Modelo1", "ABC123");
    }

    @Test
    public void crearCoche_createsNewCar() {
        Coche newCoche = model.crearCoche("Modelo2", "DEF456");
        assertNotNull(newCoche);
        assertEquals("Modelo2", newCoche.modelo);
        assertEquals("DEF456", newCoche.matricula);
    }

    @Test
    public void getCoche_returnsExistingCar() {
        Coche existingCoche = Model.getCoche("ABC123");
        assertNotNull(existingCoche);
        assertEquals("Modelo1", existingCoche.modelo);
        assertEquals("ABC123", existingCoche.matricula);
    }

    @Test
    public void getCoche_returnsNullForNonExistingCar() {
        Coche nonExistingCoche = Model.getCoche("XYZ789");
        assertNull(nonExistingCoche);
    }

    @Test
    public void cambiarVelocidad_increasesSpeed() {
        Integer newSpeed = Model.cambiarVelocidad("ABC123", 50, model);
        assertNotNull(newSpeed);
        assertEquals(50, newSpeed);
    }

    @Test
    public void cambiarVelocidad_decreasesSpeed() {
        Model.cambiarVelocidad("ABC123", 50, model);
        Integer newSpeed = Model.cambiarVelocidad("ABC123", 30, model);
        assertNotNull(newSpeed);
        assertEquals(30, newSpeed);
    }

    @Test
    public void cambiarVelocidad_returnsNullForNonExistingCar() {
        Integer newSpeed = Model.cambiarVelocidad("XYZ789", 50, model);
        assertNull(newSpeed);
    }
}