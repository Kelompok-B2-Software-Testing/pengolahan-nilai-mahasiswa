package NilaiMahasiswa;

/**
 * Parameter data untuk test NilaiMahasiswa
 * Berisi semua expected dan actual values yang digunakan dalam test cases
 * Tujuan: Menghindari redundansi dan memudahkan maintenance
 */
public class NilaiMahasiswaParams {

    // ============ Test Data untuk getNilaiAkhir() ============
    public static class GetNilaiAkhirParams {

        public static final Object[][] TEST_DATA = {
            // {tugas, uts, uas, expectedNilaiAkhir, description}
            {
                100,
                100,
                100,
                100.0f,
                "TC001: Semua nilai maksimal (100, 100, 100)",
            },
            { 0, 0, 0, 0.0f, "TC002: Semua nilai minimum (0, 0, 0)" },
            { 80, 75, 85, 80.0f, "TC003: Nilai normal (80, 75, 85)" },
            { 90, 50, 50, 66.0f, "TC004: Tugas dominan (90, 50, 50)" },
            { 50, 50, 90, 62.0f, "TC005: UAS dominan (50, 50, 90)" },
            {
                75.5f,
                80.3f,
                88.7f,
                80.92f,
                "TC006: Nilai desimal (75.5, 80.3, 88.7)",
            },
            { 70, 100, 70, 79.0f, "TC007: UTS dominan (70, 100, 70)" },
            { 30, 35, 40, 34.5f, "TC008: Nilai rendah semua (30, 35, 40)" },
            { 85, 90, 95, 89.5f, "TC009: Nilai tinggi semua (85, 90, 95)" },
            { 60, 60, 60, 60.0f, "TC010: Nilai batas kelulusan (60, 60, 60)" },
            {
                59,
                59,
                59,
                59.0f,
                "TC011: Nilai batas tidak lulus (59, 59, 59)",
            },
            { 85, 85, 85, 85.0f, "TC012: Nilai untuk grade A (85, 85, 85)" },
            { 75, 75, 75, 75.0f, "TC013: Nilai untuk grade B (75, 75, 75)" },
            { 50, 50, 50, 50.0f, "TC014: Nilai 50 (boundary D)" },
            { 42, 78, 65, 59.7f, "TC015: Nilai acak (42, 78, 65)" },
        };
    }

    // ============ Test Data untuk getTugas() ============
    public static class GetTugasParams {

        public static final Object[][] TEST_DATA = {
            // {tugas, uts, uas, expectedTugas, description}
            { 75, 80, 85, 75.0f, "Should return tugas 75" },
            { 0, 50, 60, 0.0f, "Should return tugas 0 (minimum)" },
            { 100, 50, 60, 100.0f, "Should return tugas 100 (maximum)" },
            {
                85.5f,
                70.5f,
                75.5f,
                85.5f,
                "Should return tugas 85.5 (decimal)",
            },
            { 1, 50, 60, 1.0f, "Should return tugas 1 (boundary min)" },
            { 99, 50, 60, 99.0f, "Should return tugas 99 (boundary max)" },
            { 80, 70, 75, 80.0f, "Instance 1 should return 80" },
            { 90, 85, 88, 90.0f, "Instance 2 should return 90" },
            { 60, 55, 65, 60.0f, "Instance 3 should return 60" },
        };
    }

    // ============ Test Data untuk getUts() ============
    public static class GetUtsParams {

        public static final Object[][] TEST_DATA = {
            // {tugas, uts, uas, expectedUts, description}
            { 50, 75, 80, 75.0f, "Should return UTS 75" },
            { 10, 0, 20, 0.0f, "Should return UTS 0 (minimum)" },
            { 10, 100, 20, 100.0f, "Should return UTS 100 (maximum)" },
            { 50.5f, 75.5f, 80.5f, 75.5f, "Should return UTS 75.5 (decimal)" },
            { 30, 50, 60, 50.0f, "Should return UTS 50 (mid-range)" },
            { 40, 70, 75, 70.0f, "Instance 1 should return UTS 70" },
            { 50, 85, 90, 85.0f, "Instance 2 should return UTS 85" },
        };
    }

    // ============ Test Data untuk getUas() ============
    public static class GetUasParams {

        public static final Object[][] TEST_DATA = {
            // {tugas, uts, uas, expectedUas, description}
            { 80, 75, 85, 85.0f, "Should return UAS 85" },
            { 0, 0, 0, 0.0f, "Should return UAS 0 (minimum)" },
            { 100, 100, 100, 100.0f, "Should return UAS 100 (maximum)" },
            { 50, 60, 75.5f, 75.5f, "Should return UAS 75.5 (decimal)" },
            { 20, 30, 25, 25.0f, "Should return UAS 25 (low)" },
            { 95, 90, 98, 98.0f, "Should return UAS 98 (high)" },
        };
    }

    // ============ Constant untuk calculation formula ============
    public static final float BOBOT_TUGAS = 0.4f;
    public static final float BOBOT_UTS = 0.3f;
    public static final float BOBOT_UAS = 0.3f;

    /**
     * Helper method untuk menghitung nilai akhir
     */
    public static float calculateNilaiAkhir(float tugas, float uts, float uas) {
        return (tugas * BOBOT_TUGAS) + (uts * BOBOT_UTS) + (uas * BOBOT_UAS);
    }

    /**
     * Helper method untuk validasi range nilai
     */
    public static boolean isValidNilai(float nilai) {
        return nilai >= 0 && nilai <= 100;
    }
}
