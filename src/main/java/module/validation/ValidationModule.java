package module.validation;

public class ValidationModule {
    public boolean isValid(double tugas, double uts, double uas) {
        if (!isInRange(tugas) || !isInRange(uts) || !isInRange(uas)) {
            return false;
        }
        return !(tugas == 0 && uts == 0 && uas == 0);
    }

    private boolean isInRange(double value) {
        return value >= 0 && value <= 100;
    }
}
