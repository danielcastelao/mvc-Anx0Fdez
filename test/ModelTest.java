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

}