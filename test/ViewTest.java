import cod.mvc.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    @Test
    public void muestraVelocidad_displaysCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        View.muestraVelocidad("1234ABC", 120);

        String expectedOutput = "El coche con matrícula 1234ABC tiene una velocidad de 120 km/h.\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}