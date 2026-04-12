package module.calculation;

import module.validation.ValidationModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationModuleTest {

    private final CalculationModule calculationModule =
            new CalculationModule(new ValidationModule());

    @Test
    void shouldCalculateFinalScoreForValidInput() {
        double result = calculationModule.hitungNilaiAkhir(80, 70, 90);
        assertEquals(81.0, result, 0.0001);
    }

    @Test
    void shouldReturnMinusOneForInvalidOutOfRange() {
        double result = calculationModule.hitungNilaiAkhir(101, 70, 90);
        assertEquals(-1.0, result, 0.0001);
    }

    @Test
    void shouldReturnMinusOneWhenAllZero() {
        double result = calculationModule.hitungNilaiAkhir(0, 0, 0);
        assertEquals(-1.0, result, 0.0001);
    }

    @Test
    void shouldHandleEdgeBounds() {
        double result = calculationModule.hitungNilaiAkhir(100, 0, 100);
        assertEquals(70.0, result, 0.0001);
    }
}
