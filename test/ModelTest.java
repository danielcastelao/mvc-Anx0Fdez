import cod.mvc.Coche;
import cod.mvc.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModelTest {
    @BeforeEach
    public void setup() {
        Model.crearCoche("1234ABC", "Model S", 120);
    }
    @Test
    public void getCoche_returnsCorrectCoche() {
        Coche coche = Model.getCoche("1234ABC");
        assertEquals("1234ABC", coche.getMatricula());
        assertEquals("Model S", coche.getModelo());
        assertEquals(120, coche.getVelocidad());
    }
}