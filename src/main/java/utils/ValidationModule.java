package utils;

// validation utility
public class ValidationModule {

    // input : float numeric
    // output : true or false if the numeric input is in constraint
    // for defining what is valid meaning in this program
    public boolean isValid(float input) {
        if (isInRange(input)) {
            return true;
        }
        return false;
    }

    // input : double value
    // output : true or false if the numeric input is in range
    // for defining program input range
    private boolean isInRange(double value) {
        return value >= 0 && value <= 100;
    }
}
