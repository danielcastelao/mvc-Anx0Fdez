import cod.mvc.model.Coche;
import cod.mvc.model.Model;
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

    @Test
    public void getCoche_returnsNullWhenCocheDoesNotExist() {
        Coche coche = Model.getCoche("9999XYZ");
        assertNull(coche);
    }

    @Test
    public void cambiarVelocidad_changesCocheVelocidad() {
        Model.cambiarVelocidad("1234ABC", 150);
        Coche coche = Model.getCoche("1234ABC");
        assertEquals(150, coche.getVelocidad());
    }

    @Test
    public void cambiarVelocidad_doesNotChangeVelocidadWhenCocheDoesNotExist() {
        Model.cambiarVelocidad("9999XYZ", 150);
        Coche coche = Model.getCoche("9999XYZ");
        assertNull(coche);
    }

    @Test
    public void getVelocidad_returnsCorrectVelocidad() {
        int velocidad = Model.getVelocidad("1234ABC");
        assertEquals(120, velocidad);
    }

    @Test
    public void getVelocidad_returnsNegativeWhenCocheDoesNotExist() {
        int velocidad = Model.getVelocidad("9999XYZ");
        assertEquals(-1, velocidad);
    }
}