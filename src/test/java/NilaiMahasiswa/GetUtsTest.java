package NilaiMahasiswa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.NilaiMahasiswa;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("NilaiMahasiswa.getUts()")
public class GetUtsTest {

    @ParameterizedTest(name = "{4}")
    @MethodSource("provideGetUtsTestCases")
    @DisplayName("Test getUts() with various input combinations")
    void testGetUts(
        float tugas,
        float uts,
        float uas,
        float expectedUts,
        String description
    ) {
        // Arrange
        NilaiMahasiswa nilai = new NilaiMahasiswa(tugas, uts, uas);

        // Act
        float result = nilai.getUts();

        // Assert
        assertEquals(
            expectedUts,
            result,
            0.01f,
            String.format(
                "Expected: %.2f, Got: %.2f - %s",
                expectedUts,
                result,
                description
            )
        );
    }

    static Stream<Object[]> provideGetUtsTestCases() {
        return Stream.of(NilaiMahasiswaParams.GetUtsParams.TEST_DATA);
    }
}
