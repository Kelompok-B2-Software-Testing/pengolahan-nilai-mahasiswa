package ValidationModule;

public class ValidationModuleParams {

    // Test case structure
    public static class TestCase {

        public final float input;
        public final boolean expected;
        public final String description;

        public TestCase(float input, boolean expected, String description) {
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    // Valid test cases (nilai dalam range 0-100)
    public static TestCase[] getValidTestCases() {
        return new TestCase[] {
            new TestCase(0, true, "TC001: Minimum boundary (0)"),
            new TestCase(100, true, "TC002: Maximum boundary (100)"),
            new TestCase(50, true, "TC003: Middle value (50)"),
            new TestCase(25.5f, true, "TC004: Decimal value (25.5)"),
            new TestCase(99.99f, true, "TC005: Near maximum (99.99)"),
            new TestCase(0.01f, true, "TC006: Near minimum (0.01)"),
            new TestCase(75.75f, true, "TC007: Random decimal (75.75)"),
            new TestCase(1, true, "TC008: Just above minimum (1)"),
            new TestCase(99, true, "TC009: Just below maximum (99)"),
            new TestCase(60, true, "TC010: Passing grade boundary (60)"),
            new TestCase(85, true, "TC011: Grade A boundary (85)"),
            new TestCase(70, true, "TC012: Grade B boundary (70)"),
        };
    }

    // Invalid test cases (nilai di luar range 0-100)
    public static TestCase[] getInvalidTestCases() {
        return new TestCase[] {
            new TestCase(-1, false, "TC013: Below minimum (-1)"),
            new TestCase(-50, false, "TC014: Negative large (-50)"),
            new TestCase(101, false, "TC015: Above maximum (101)"),
            new TestCase(150, false, "TC016: Well above maximum (150)"),
            new TestCase(100.01f, false, "TC017: Just above maximum (100.01)"),
            new TestCase(-0.01f, false, "TC018: Just below minimum (-0.01)"),
            new TestCase(-100, false, "TC019: Negative boundary (-100)"),
            new TestCase(200.5f, false, "TC020: Much above maximum (200.5)"),
            new TestCase(500, false, "TC021: Extremely above maximum (500)"),
            new TestCase(-999, false, "TC022: Extremely negative (-999)"),
        };
    }

    // All test cases combined
    public static TestCase[] getAllTestCases() {
        TestCase[] valid = getValidTestCases();
        TestCase[] invalid = getInvalidTestCases();
        TestCase[] all = new TestCase[valid.length + invalid.length];

        System.arraycopy(valid, 0, all, 0, valid.length);
        System.arraycopy(invalid, 0, all, valid.length, invalid.length);

        return all;
    }

    // Get test case by index
    public static TestCase getTestCase(int index) {
        TestCase[] allCases = getAllTestCases();
        if (index >= 0 && index < allCases.length) {
            return allCases[index];
        }
        throw new IndexOutOfBoundsException(
            "Test case index out of bounds: " + index
        );
    }

    // Get total test cases count
    public static int getTotalTestCases() {
        return getAllTestCases().length;
    }
}
