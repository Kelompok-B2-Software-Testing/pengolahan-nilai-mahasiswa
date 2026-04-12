package module.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationModuleTest {

    private final ValidationModule validationModule = new ValidationModule();

    @Test
    void shouldReturnTrueForValidScores() {
        assertTrue(validationModule.isValid(80, 75, 90));
    }

    @Test
    void shouldReturnFalseWhenAnyScoreOutOfRange() {
        assertFalse(validationModule.isValid(-1, 50, 60));
        assertFalse(validationModule.isValid(50, 101, 60));
        assertFalse(validationModule.isValid(50, 60, 100.5));
    }

    @Test
    void shouldReturnFalseWhenAllScoresZero() {
        assertFalse(validationModule.isValid(0, 0, 0));
    }

    @Test
    void shouldReturnTrueWhenSomeScoresZeroButNotAll() {
        assertTrue(validationModule.isValid(0, 60, 0));
    }
}
