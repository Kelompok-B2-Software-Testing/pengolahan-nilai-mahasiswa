package NilaiMahasiswa;

import static org.junit.jupiter.api.Assertions.*;

import domain.NilaiMahasiswa;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("NilaiMahasiswa.getUas() - Using Parameter Template")
public class GetUasTest {

    private static Stream<Arguments> getUasTestData() {
        return Arrays.stream(NilaiMahasiswaParams.GetUasParams.TEST_DATA).map(
            Arguments::of
        );
    }

    @ParameterizedTest(name = "{4}")
    @MethodSource("getUasTestData")
    @DisplayName("Parameterized test for getUas() with various inputs")
    void testGetUasWithTemplateParams(
        float tugas,
        float uts,
        float uas,
        float expectedUas,
        String description
    ) {
        NilaiMahasiswa nilai = new NilaiMahasiswa(tugas, uts, uas);
        float actualUas = nilai.getUas();

        assertEquals(
            expectedUas,
            actualUas,
            NilaiMahasiswaParams.BOBOT_UTS,
            "Failed: " + description
        );
    }

    @Test
    @DisplayName("TC001: Should return UAS 100 (maximum boundary)")
    void testGetUasMaximum() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(100, 100, 100);
        assertEquals(100.0f, nilai.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
    }

    @Test
    @DisplayName("TC002: Should return UAS 0 (minimum boundary)")
    void testGetUasMinimum() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(0, 0, 0);
        assertEquals(0.0f, nilai.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
    }

    @Test
    @DisplayName("TC003: Should return UAS 75.5 (decimal value)")
    void testGetUasDecimal() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(50, 60, 75.5f);
        assertEquals(75.5f, nilai.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
    }

    @Test
    @DisplayName("TC004: Should return consistent value on multiple calls")
    void testGetUasConsistency() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(80, 75, 85);
        float firstCall = nilai.getUas();
        float secondCall = nilai.getUas();
        float thirdCall = nilai.getUas();

        assertEquals(
            firstCall,
            secondCall,
            NilaiMahasiswaParams.BOBOT_UTS,
            "Second call should equal first call"
        );
        assertEquals(
            secondCall,
            thirdCall,
            NilaiMahasiswaParams.BOBOT_UTS,
            "Third call should equal second call"
        );
        assertEquals(
            85.0f,
            firstCall,
            NilaiMahasiswaParams.BOBOT_UTS,
            "Value should be 85.0"
        );
    }

    @Test
    @DisplayName("TC005: Should be independent from tugas and uts values")
    void testGetUasIndependence() {
        NilaiMahasiswa nilai = new NilaiMahasiswa(0, 100, 80);
        assertEquals(
            80.0f,
            nilai.getUas(),
            NilaiMahasiswaParams.BOBOT_UTS,
            "UAS should return 80 regardless of tugas and uts"
        );
    }

    @Test
    @DisplayName("TC006: Should handle multiple instances independently")
    void testGetUasMultipleInstances() {
        NilaiMahasiswa nilai1 = new NilaiMahasiswa(80, 75, 85);
        NilaiMahasiswa nilai2 = new NilaiMahasiswa(50, 60, 75.5f);
        NilaiMahasiswa nilai3 = new NilaiMahasiswa(20, 30, 25);

        assertEquals(85.0f, nilai1.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
        assertEquals(75.5f, nilai2.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
        assertEquals(25.0f, nilai3.getUas(), NilaiMahasiswaParams.BOBOT_UTS);
    }
}
