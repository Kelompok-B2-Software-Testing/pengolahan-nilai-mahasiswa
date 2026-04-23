package InputUtils;

public class InputUtilsParams {

    // Valid input test cases
    public static class ValidInputTestCase {

        public final String input;
        public final float expected;
        public final String description;

        public ValidInputTestCase(
            String input,
            float expected,
            String description
        ) {
            this.input = input;
            this.expected = expected;
            this.description = description;
        }
    }

    // Invalid input test cases (need retry)
    public static class InvalidInputTestCase {

        public final String[] inputs; // sequence of inputs
        public final float expected;
        public final String description;

        public InvalidInputTestCase(
            String[] inputs,
            float expected,
            String description
        ) {
            this.inputs = inputs;
            this.expected = expected;
            this.description = description;
        }
    }

    // Boundary test cases
    public static class BoundaryTestCase {

        public final float value;
        public final String description;
        public final String boundary;

        public BoundaryTestCase(
            float value,
            String description,
            String boundary
        ) {
            this.value = value;
            this.description = description;
            this.boundary = boundary;
        }
    }

    // ===== VALID INPUT CASES =====
    public static final ValidInputTestCase[] VALID_INPUTS = {
        new ValidInputTestCase("50.5", 50.5f, "TC001: Valid decimal input"),
        new ValidInputTestCase("75", 75.0f, "TC002: Valid integer input"),
        new ValidInputTestCase("0", 0.0f, "TC003: Minimum valid value"),
        new ValidInputTestCase("100", 100.0f, "TC004: Maximum valid value"),
        new ValidInputTestCase("60", 60.0f, "TC005: Passing grade boundary"),
        new ValidInputTestCase("85", 85.0f, "TC006: Grade A boundary"),
        new ValidInputTestCase("70", 70.0f, "TC007: Mid-range value"),
        new ValidInputTestCase("45.5", 45.5f, "TC008: Decimal failing grade"),
        new ValidInputTestCase("99.99", 99.99f, "TC009: High decimal value"),
        new ValidInputTestCase("0.01", 0.01f, "TC010: Low decimal value"),
    };

    // ===== INVALID INPUT CASES (need retry) =====
    public static final InvalidInputTestCase[] INVALID_THEN_VALID = {
        new InvalidInputTestCase(
            new String[] { "abc", "50" },
            50.0f,
            "TC011: Invalid text input then valid"
        ),
        new InvalidInputTestCase(
            new String[] { "-50", "50" },
            50.0f,
            "TC012: Negative out-of-range then valid"
        ),
        new InvalidInputTestCase(
            new String[] { "150", "80" },
            80.0f,
            "TC013: Above range (150) then valid (80)"
        ),
        new InvalidInputTestCase(
            new String[] { "abc", "xyz", "60" },
            60.0f,
            "TC014: Multiple invalid text inputs then valid"
        ),
        new InvalidInputTestCase(
            new String[] { "-10", "150", "45" },
            45.0f,
            "TC015: Multiple error types (negative, out-of-range) then valid"
        ),
    };

    // ===== BOUNDARY TEST CASES =====
    public static final BoundaryTestCase[] BOUNDARY_VALUES = {
        new BoundaryTestCase(0.0f, "Minimum boundary (0)", "MIN"),
        new BoundaryTestCase(100.0f, "Maximum boundary (100)", "MAX"),
        new BoundaryTestCase(50.0f, "Mid-range boundary (50)", "MID"),
        new BoundaryTestCase(60.0f, "Passing grade boundary (60)", "PASS"),
        new BoundaryTestCase(85.0f, "Grade A boundary (85)", "GRADE_A"),
        new BoundaryTestCase(70.0f, "Grade B boundary (70)", "GRADE_B"),
        new BoundaryTestCase(59.9f, "Just below passing (59.9)", "BELOW_PASS"),
        new BoundaryTestCase(60.1f, "Just above passing (60.1)", "ABOVE_PASS"),
    };

    // ===== EDGE CASE VALUES =====
    public static final float[] EDGE_CASE_VALUES = {
        0.0f,
        0.01f,
        0.1f,
        1.0f,
        50.0f,
        99.0f,
        99.9f,
        99.99f,
        100.0f,
    };

    // ===== CONSTANTS FOR TEST CASES =====
    public static final float FLOAT_TOLERANCE = 0.01f;
    public static final float MIN_VALID = 0.0f;
    public static final float MAX_VALID = 100.0f;

    // ===== PROMPT MESSAGES =====
    public static final String PROMPT_TUGAS = "Masukkan nilai Tugas (0-100):";
    public static final String PROMPT_UTS = "Masukkan nilai UTS (0-100):";
    public static final String PROMPT_UAS = "Masukkan nilai UAS (0-100):";
}
