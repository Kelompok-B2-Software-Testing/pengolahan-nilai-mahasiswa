package NilaiMahasiswa;

import static org.junit.jupiter.api.Assertions.*;

import domain.NilaiMahasiswa;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("NilaiMahasiswa.getNilaiAkhir() - Parameterized Tests")
public class GetNilaiAkhirTest {

    @ParameterizedTest(name = "[{index}] {4}")
    @MethodSource("provideGetNilaiAkhirTestData")
    @DisplayName("Test getNilaiAkhir dengan berbagai kombinasi nilai")
    void testGetNilaiAkhir(
        float tugas,
        float uts,
        float uas,
        float expected,
        String description
    ) {
        NilaiMahasiswa nilai = new NilaiMahasiswa(tugas, uts, uas);
        float actual = nilai.getNilaiAkhir();

        assertEquals(
            expected,
            actual,
            NilaiMahasiswaParams.BOBOT_UTS,
            String.format(
                "FAILED: %s | Expected: %.2f | Actual: %.2f",
                description,
                expected,
                actual
            )
        );
    }

    static Stream<Arguments> provideGetNilaiAkhirTestData() {
        return Stream.of(
            NilaiMahasiswaParams.GetNilaiAkhirParams.TEST_DATA
        ).map(row ->
            Arguments.of(
                ((Number) row[0]).floatValue(),
                ((Number) row[1]).floatValue(),
                ((Number) row[2]).floatValue(),
                ((Number) row[3]).floatValue(),
                (String) row[4]
            )
        );
    }
}
