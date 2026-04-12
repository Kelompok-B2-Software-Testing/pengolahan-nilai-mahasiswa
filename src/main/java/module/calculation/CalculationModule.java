package module.calculation;

import module.validation.ValidationModule;

public class CalculationModule {
    private final ValidationModule validationModule;

    public CalculationModule(ValidationModule validationModule) {
        this.validationModule = validationModule;
    }

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        if (!validationModule.isValid(tugas, uts, uas)) {
            return -1;
        }
        return (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
    }
}
