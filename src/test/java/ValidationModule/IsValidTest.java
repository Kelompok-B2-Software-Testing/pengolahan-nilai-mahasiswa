package ValidationModule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ValidationModule;

@DisplayName("ValidationModule - isValid() Test Suite")
public class IsValidTest {

    private final ValidationModule validationModule = new ValidationModule();

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("provideValidTestCases")
    @DisplayName(
        "Valid Input Values - Should return TRUE for values in range 0-100"
    )
    public void testIsValidWithValidValues(
        ValidationModuleParams.TestCase testCase
    ) {
        boolean result = validationModule.isValid(testCase.input);

        assertEquals(
            testCase.expected,
            result,
            String.format(
                "FAILED: %s | Input: %.2f | Expected: %s | Got: %s",
                testCase.description,
                testCase.input,
                testCase.expected,
                result
            )
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("provideInvalidTestCases")
    @DisplayName(
        "Invalid Input Values - Should return FALSE for values outside range 0-100"
    )
    public void testIsValidWithInvalidValues(
        ValidationModuleParams.TestCase testCase
    ) {
        boolean result = validationModule.isValid(testCase.input);

        assertEquals(
            testCase.expected,
            result,
            String.format(
                "FAILED: %s | Input: %.2f | Expected: %s | Got: %s",
                testCase.description,
                testCase.input,
                testCase.expected,
                result
            )
        );
    }

    static Stream<ValidationModuleParams.TestCase> provideValidTestCases() {
        return Stream.of(ValidationModuleParams.getValidTestCases());
    }

    static Stream<ValidationModuleParams.TestCase> provideInvalidTestCases() {
        return Stream.of(ValidationModuleParams.getInvalidTestCases());
    }
}
