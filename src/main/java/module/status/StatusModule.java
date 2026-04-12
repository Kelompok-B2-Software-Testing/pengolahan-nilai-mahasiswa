package module.status;

public class StatusModule {
    public String getStatus(double nilaiAkhir) {
        if (nilaiAkhir >= 60) {
            return "Lulus";
        }
        return "Tidak Lulus";
    }
}
