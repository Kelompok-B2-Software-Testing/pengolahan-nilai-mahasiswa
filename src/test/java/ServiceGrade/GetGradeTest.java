package ServiceGrade;

import static org.junit.jupiter.api.Assertions.*;

import domain.ServiceGrade;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("ServiceGrade - getGrade() Tests")
public class GetGradeTest {

    private ServiceGrade serviceGrade;

    @BeforeEach
    void setUp() {
        serviceGrade = new ServiceGrade();
    }

    @ParameterizedTest
    @MethodSource("provideAllGradeTestCases")
    @DisplayName("Test all grade ranges with parameterized test")
    void testGetGradeAllCases(ServiceGradeParams.GradeTestCase testCase) {
        float nilai = testCase.nilai;
        char expectedGrade = testCase.expectedGrade;

        char result = serviceGrade.getGrade(nilai);

        assertEquals(
            expectedGrade,
            result,
            String.format(
                "Failed: %s Input: %.2f Expected: %c Got: %c",
                testCase.description,
                nilai,
                expectedGrade,
                result
            )
        );
    }

    @Test
    @DisplayName("Test Grade A - Boundary minimum (85)")
    void testGetGradeA_Boundary() {
        assertEquals('A', serviceGrade.getGrade(85));
    }

    @Test
    @DisplayName("Test Grade A - Middle range (90)")
    void testGetGradeA_Middle() {
        assertEquals('A', serviceGrade.getGrade(90));
    }

    @Test
    @DisplayName("Test Grade A - Maximum (100)")
    void testGetGradeA_Maximum() {
        assertEquals('A', serviceGrade.getGrade(100));
    }

    @Test
    @DisplayName("Test Grade B - Boundary minimum (70)")
    void testGetGradeB_LowerBoundary() {
        assertEquals('B', serviceGrade.getGrade(70));
    }

    @Test
    @DisplayName("Test Grade B - Upper boundary (84.9)")
    void testGetGradeB_UpperBoundary() {
        assertEquals('B', serviceGrade.getGrade(84.9f));
    }

    @Test
    @DisplayName("Test Grade B - Middle range (75)")
    void testGetGradeB_Middle() {
        assertEquals('B', serviceGrade.getGrade(75));
    }

    @Test
    @DisplayName("Test Grade C - Boundary minimum (60)")
    void testGetGradeC_LowerBoundary() {
        assertEquals('C', serviceGrade.getGrade(60));
    }

    @Test
    @DisplayName("Test Grade C - Upper boundary (69.9)")
    void testGetGradeC_UpperBoundary() {
        assertEquals('C', serviceGrade.getGrade(69.9f));
    }

    @Test
    @DisplayName("Test Grade C - Middle range (65)")
    void testGetGradeC_Middle() {
        assertEquals('C', serviceGrade.getGrade(65));
    }

    @Test
    @DisplayName("Test Grade D - Boundary minimum (50)")
    void testGetGradeD_LowerBoundary() {
        assertEquals('D', serviceGrade.getGrade(50));
    }

    @Test
    @DisplayName("Test Grade D - Upper boundary (59.9)")
    void testGetGradeD_UpperBoundary() {
        assertEquals('D', serviceGrade.getGrade(59.9f));
    }

    @Test
    @DisplayName("Test Grade D - Middle range (55)")
    void testGetGradeD_Middle() {
        assertEquals('D', serviceGrade.getGrade(55));
    }

    @Test
    @DisplayName("Test Grade E - Just below D (49.9)")
    void testGetGradeE_JustBelow50() {
        assertEquals('E', serviceGrade.getGrade(49.9f));
    }

    @Test
    @DisplayName("Test Grade E - Minimum (0)")
    void testGetGradeE_Minimum() {
        assertEquals('E', serviceGrade.getGrade(0));
    }

    @Test
    @DisplayName("Test Grade E - Middle range (25)")
    void testGetGradeE_Middle() {
        assertEquals('E', serviceGrade.getGrade(25));
    }

    static Stream<ServiceGradeParams.GradeTestCase> provideAllGradeTestCases() {
        return Stream.of(ServiceGradeParams.ALL_GRADE_TESTS);
    }
}
