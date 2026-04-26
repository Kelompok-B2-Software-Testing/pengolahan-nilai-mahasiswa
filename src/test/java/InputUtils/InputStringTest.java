package InputUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputUtils;

@DisplayName("InputUtils.inputString()")
public class InputStringTest {

    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("Returns the exact user input string")
    void testInputStringReturnsUserInput() {
        setInput("Budi\n");
        InputUtils inputUtils = new InputUtils();

        String result = inputUtils.inputString("Masukkan nama");

        assertEquals("Budi", result);
    }
}
