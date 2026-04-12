package module.input;

public class ScoreInput {
    private final double nilaiTugas;
    private final double nilaiUts;
    private final double nilaiUas;

    public ScoreInput(double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUts() {
        return nilaiUts;
    }

    public double getNilaiUas() {
        return nilaiUas;
    }
}
