package InputUtils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.InputUtils;

@DisplayName("InputUtils.inputFloat() - Using Parameter Template")
public class InputFloatTest {

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

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("provideValidInputs")
    @DisplayName("Valid input values")
    void testValidInputs(InputUtilsParams.ValidInputTestCase testCase) {
        setInput(testCase.input + "\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(
            testCase.expected,
            result,
            InputUtilsParams.FLOAT_TOLERANCE,
            testCase.description
        );
    }

    static Stream<InputUtilsParams.ValidInputTestCase> provideValidInputs() {
        return Stream.of(InputUtilsParams.VALID_INPUTS);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("provideInvalidThenValid")
    @DisplayName("Invalid input with retry to valid")
    void testInvalidThenValidRetry(
        InputUtilsParams.InvalidInputTestCase testCase
    ) {
        StringBuilder inputString = new StringBuilder();
        for (String input : testCase.inputs) {
            inputString.append(input).append("\n");
        }
        setInput(inputString.toString());
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(
            testCase.expected,
            result,
            InputUtilsParams.FLOAT_TOLERANCE,
            testCase.description
        );
    }

    static Stream<
        InputUtilsParams.InvalidInputTestCase
    > provideInvalidThenValid() {
        return Stream.of(InputUtilsParams.INVALID_THEN_VALID);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("provideBoundaryValues")
    @DisplayName("Boundary value validation")
    void testBoundaryValues(InputUtilsParams.BoundaryTestCase testCase) {
        setInput(testCase.value + "\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(
            testCase.value,
            result,
            InputUtilsParams.FLOAT_TOLERANCE,
            testCase.description
        );
    }

    static Stream<InputUtilsParams.BoundaryTestCase> provideBoundaryValues() {
        return Stream.of(InputUtilsParams.BOUNDARY_VALUES);
    }

    @Test
    @DisplayName("Individual TC001: Minimum valid value (0)")
    void testMinimumValue() {
        setInput("0\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(
            InputUtilsParams.MIN_VALID,
            result,
            InputUtilsParams.FLOAT_TOLERANCE
        );
    }

    @Test
    @DisplayName("Individual TC002: Maximum valid value (100)")
    void testMaximumValue() {
        setInput("100\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(
            InputUtilsParams.MAX_VALID,
            result,
            InputUtilsParams.FLOAT_TOLERANCE
        );
    }

    @Test
    @DisplayName("Individual TC003: Passing grade boundary (60)")
    void testPassingBoundary() {
        setInput("60\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(60.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }

    @Test
    @DisplayName("Individual TC004: Grade A boundary (85)")
    void testGradeABoundary() {
        setInput("85\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(85.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }

    @Test
    @DisplayName("Individual TC005: With prompt - Input Tugas")
    void testWithPromptTugas() {
        setInput("75\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat(InputUtilsParams.PROMPT_TUGAS);

        assertEquals(75.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }

    @Test
    @DisplayName("Individual TC006: With prompt - Input UTS")
    void testWithPromptUts() {
        setInput("80\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat(InputUtilsParams.PROMPT_UTS);

        assertEquals(80.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }

    @Test
    @DisplayName("Individual TC007: With prompt - Input UAS")
    void testWithPromptUas() {
        setInput("90\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat(InputUtilsParams.PROMPT_UAS);

        assertEquals(90.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }

    @Test
    @DisplayName("Individual TC008: Small decimal value (0.01)")
    void testSmallDecimal() {
        setInput("0.01\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(0.01f, result, 0.001f);
    }

    @Test
    @DisplayName("Individual TC009: High decimal value (99.99)")
    void testHighDecimal() {
        setInput("99.99\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertTrue(result > 99.9f && result <= InputUtilsParams.MAX_VALID);
    }

    @Test
    @DisplayName("Individual TC010: Mid-range value (50)")
    void testMidRangeValue() {
        setInput("50\n");
        InputUtils inputUtils = new InputUtils();
        float result = inputUtils.inputFloat("Enter value");

        assertEquals(50.0f, result, InputUtilsParams.FLOAT_TOLERANCE);
    }
}
