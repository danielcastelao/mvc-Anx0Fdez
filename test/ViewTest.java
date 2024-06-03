import cod.mvc.model.Coche;
import cod.mvc.view.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {

@Test
public void mostrarCoche_ShouldPrintCorrectly() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Coche coche = new Coche("ModeloTest", "ABC123");
    coche.velocidad = 120;

    View.mostrarCoche(coche);
    assertEquals("[View] Modelo: ModeloTest, Matricula: ABC123, Velocidad: 120km/hr", outContent.toString().trim());
}

}