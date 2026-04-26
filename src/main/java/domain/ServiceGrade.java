package domain;

// Grading service and defining PASS or FAIL
public class ServiceGrade {

    // input : float value from final score
    // output : char grade base on score scope
    // returning grade base on value scope constraint
    public char getGrade(float nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return 'A';
        }
        if (nilaiAkhir >= 70) {
            return 'B';
        }
        if (nilaiAkhir >= 60) {
            return 'C';
        }
        if (nilaiAkhir >= 50) {
            return 'D';
        }
        return 'E';
    }

    // input : float score
    // output : PASS xor FAIL
    // defining score status
    public String getStatus(float nilai) {
        if (nilai >= 60) {
            return "Lulus";
        }
        return "Tidak Lulus";
    }
}
