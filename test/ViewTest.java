import cod.mvc.model.Coche;
import cod.mvc.view.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Esta clase contiene pruebas unitarias para la clase View.
 */
public class ViewTest {

    /**
     * Esta prueba verifica si el método mostrarCoche imprime los detalles del coche correctamente.
     */
    @Test
    public void mostrarCoche_ShouldPrintCorrectly() {
        // Crear un stream para contener la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Crear un objeto coche
        Coche coche = new Coche("ModeloTest", "ABC123");
        coche.velocidad = 120;

        // Llamar al método a probar
        View.mostrarCoche(coche);

        // Verificar si la salida del método es la esperada
        assertEquals("[View] Modelo: ModeloTest, Matricula: ABC123, Velocidad: 120km/hr", outContent.toString().trim());
    }

    /**
     * Esta prueba verifica si el método solicitarDatosCoche devuelve los detalles correctos del coche.
     */
    @Test
    public void solicitarDatosCoche_ShouldReturnCorrectly() {
        // Preparar el stream de entrada
        String input = "ModeloTest\nABC123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Llamar al método a probar
        String[] result = View.solicitarDatosCoche();

        // Verificar si la salida del método es la esperada
        assertEquals("ModeloTest", result[0]);
        assertEquals("ABC123", result[1]);
    }
}