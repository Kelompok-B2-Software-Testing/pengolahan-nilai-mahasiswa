package NilaiMahasiswa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.NilaiMahasiswa;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("NilaiMahasiswa.getTugas()")
public class GetTugasTest {

    @ParameterizedTest(name = "{4}")
    @MethodSource("provideTugasTestData")
    @DisplayName("Test getTugas() with parameterized values")
    void testGetTugas(
        float tugas,
        float uts,
        float uas,
        float expectedTugas,
        String description
    ) {
        // Arrange
        NilaiMahasiswa nilai = new NilaiMahasiswa(tugas, uts, uas);

        // Act
        float result = nilai.getTugas();

        // Assert
        assertEquals(
            expectedTugas,
            result,
            0.01f,
            String.format(
                "Failed: %s | Expected: %.2f | Got: %.2f",
                description,
                expectedTugas,
                result
            )
        );
    }

    static Stream<
        org.junit.jupiter.params.provider.Arguments
    > provideTugasTestData() {
        return Stream.of(NilaiMahasiswaParams.GetTugasParams.TEST_DATA).map(
            testData ->
                org.junit.jupiter.params.provider.Arguments.of(
                    testData[0],
                    testData[1],
                    testData[2],
                    testData[3],
                    testData[4]
                )
        );
    }

    @Test
    @DisplayName(
        "Consistency Test: getTugas() returns same value on multiple calls"
    )
    void testGetTugasConsistency() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(75, 80, 85);

        float result1 = nilai.getTugas();
        float result2 = nilai.getTugas();
        float result3 = nilai.getTugas();

        assertEquals(
            result1,
            result2,
            "Should return same value on consecutive calls"
        );
        assertEquals(
            result2,
            result3,
            "Should return same value on consecutive calls"
        );
        assertEquals(75.0f, result1, "Should consistently return 75");
    }

    @Test
    @DisplayName(
        "Independence Test: getTugas() returns independent value for each instance"
    )
    void testGetTugasIndependence() {
        NilaiMahasiswa nilai1 = new NilaiMahasiswa(80, 70, 75);
        NilaiMahasiswa nilai2 = new NilaiMahasiswa(90, 85, 88);
        NilaiMahasiswa nilai3 = new NilaiMahasiswa(60, 55, 65);

        assertEquals(80.0f, nilai1.getTugas(), "Instance 1 should return 80");
        assertEquals(90.0f, nilai2.getTugas(), "Instance 2 should return 90");
        assertEquals(60.0f, nilai3.getTugas(), "Instance 3 should return 60");
    }
}
