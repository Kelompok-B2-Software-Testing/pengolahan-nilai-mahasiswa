package module.grade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeModuleTest {

    private final GradeModule gradeModule = new GradeModule();

    @Test
    void shouldReturnAForScoresAtOrAbove85() {
        assertEquals("A", gradeModule.getGrade(85));
        assertEquals("A", gradeModule.getGrade(100));
    }

    @Test
    void shouldReturnBForScoresBetween70And84() {
        assertEquals("B", gradeModule.getGrade(70));
        assertEquals("B", gradeModule.getGrade(84));
    }

    @Test
    void shouldReturnCForScoresBetween60And69() {
        assertEquals("C", gradeModule.getGrade(60));
        assertEquals("C", gradeModule.getGrade(69));
    }

    @Test
    void shouldReturnDForScoresBetween50And59() {
        assertEquals("D", gradeModule.getGrade(50));
        assertEquals("D", gradeModule.getGrade(59));
    }

    @Test
    void shouldReturnEForScoresBelow50() {
        assertEquals("E", gradeModule.getGrade(49.99));
        assertEquals("E", gradeModule.getGrade(0));
    }
}
