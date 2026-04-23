package ServiceGrade;

import static org.junit.jupiter.api.Assertions.*;

import domain.ServiceGrade;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("ServiceGrade - getStatus() Test Cases")
public class GetStatusTest {

    private final ServiceGrade serviceGrade = new ServiceGrade();

    // ===== Parameterized Tests for LULUS (nilai >= 60) =====
    @ParameterizedTest(name = "{0}")
    @MethodSource("getLulusTestCases")
    @DisplayName("Test cases for LULUS status (nilai >= 60)")
    void testGetStatusLulus(ServiceGradeParams.StatusTestCase testCase) {
        // Arrange
        float nilai = testCase.nilai;
        String expected = testCase.expectedStatus;

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(
            expected,
            actual,
            String.format(
                "Nilai %.2f should return '%s' - %s",
                nilai,
                expected,
                testCase.description
            )
        );
    }

    // ===== Parameterized Tests for TIDAK LULUS (nilai < 60) =====
    @ParameterizedTest(name = "{0}")
    @MethodSource("getTidakLulusTestCases")
    @DisplayName("Test cases for TIDAK LULUS status (nilai < 60)")
    void testGetStatusTidakLulus(ServiceGradeParams.StatusTestCase testCase) {
        // Arrange
        float nilai = testCase.nilai;
        String expected = testCase.expectedStatus;

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(
            expected,
            actual,
            String.format(
                "Nilai %.2f should return '%s' - %s",
                nilai,
                expected,
                testCase.description
            )
        );
    }

    // ===== Parameterized Tests - All Combined =====
    @ParameterizedTest(name = "{0}")
    @MethodSource("getAllStatusTestCases")
    @DisplayName("All status test cases")
    void testGetStatusAll(ServiceGradeParams.StatusTestCase testCase) {
        // Arrange
        float nilai = testCase.nilai;
        String expected = testCase.expectedStatus;

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(
            expected,
            actual,
            String.format(
                "Nilai %.2f should return '%s' - %s",
                nilai,
                expected,
                testCase.description
            )
        );
    }

    // ===== Specific Boundary Tests =====
    @Test
    @DisplayName("Test boundary exactly at 60 (passing threshold)")
    void testGetStatusExactly60() {
        // Arrange
        float nilai = 60;
        String expected = "Lulus";

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test just below 60 boundary")
    void testGetStatusJustBelow60() {
        // Arrange
        float nilai = 59.9f;
        String expected = "Tidak Lulus";

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test minimum value (0)")
    void testGetStatusMinimum() {
        // Arrange
        float nilai = 0;
        String expected = "Tidak Lulus";

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test maximum value (100)")
    void testGetStatusMaximum() {
        // Arrange
        float nilai = 100;
        String expected = "Lulus";

        // Act
        String actual = serviceGrade.getStatus(nilai);

        // Assert
        assertEquals(expected, actual);
    }

    // ===== Provider Methods =====
    /**
     * Provides all LULUS test cases from ServiceGradeParams
     */
    static Stream<ServiceGradeParams.StatusTestCase> getLulusTestCases() {
        return java.util.Arrays.stream(ServiceGradeParams.STATUS_LULUS_TESTS);
    }

    /**
     * Provides all TIDAK LULUS test cases from ServiceGradeParams
     */
    static Stream<ServiceGradeParams.StatusTestCase> getTidakLulusTestCases() {
        return java.util.Arrays.stream(
            ServiceGradeParams.STATUS_TIDAK_LULUS_TESTS
        );
    }

    /**
     * Provides all status test cases from ServiceGradeParams
     */
    static Stream<ServiceGradeParams.StatusTestCase> getAllStatusTestCases() {
        return java.util.Arrays.stream(ServiceGradeParams.ALL_STATUS_TESTS);
    }
}
