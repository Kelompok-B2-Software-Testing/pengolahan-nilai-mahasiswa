package ServiceGrade;

public class ServiceGradeParams {

    // Parameters for getGrade() method
    public static class GradeTestCase {
        public final float nilai;
        public final char expectedGrade;
        public final String description;

        public GradeTestCase(float nilai, char expectedGrade, String description) {
            this.nilai = nilai;
            this.expectedGrade = expectedGrade;
            this.description = description;
        }
    }

    // Parameters for getStatus() method
    public static class StatusTestCase {
        public final float nilai;
        public final String expectedStatus;
        public final String description;

        public StatusTestCase(float nilai, String expectedStatus, String description) {
            this.nilai = nilai;
            this.expectedStatus = expectedStatus;
            this.description = description;
        }
    }

    // Grade Test Data - Grade A (>= 85)
    public static final GradeTestCase[] GRADE_A_TESTS = {
        new GradeTestCase(85, 'A', "Grade A - Boundary minimum (85)"),
        new GradeTestCase(90, 'A', "Grade A - Middle range (90)"),
        new GradeTestCase(100, 'A', "Grade A - Maximum (100)"),
        new GradeTestCase(86, 'A', "Grade A - Just above boundary (86)"),
        new GradeTestCase(95, 'A', "Grade A - High value (95)"),
    };

    // Grade Test Data - Grade B (70-84)
    public static final GradeTestCase[] GRADE_B_TESTS = {
        new GradeTestCase(70, 'B', "Grade B - Boundary minimum (70)"),
        new GradeTestCase(84.9f, 'B', "Grade B - Just below A (84.9)"),
        new GradeTestCase(75, 'B', "Grade B - Middle range (75)"),
        new GradeTestCase(72, 'B', "Grade B - Low in range (72)"),
        new GradeTestCase(80, 'B', "Grade B - High in range (80)"),
    };

    // Grade Test Data - Grade C (60-69)
    public static final GradeTestCase[] GRADE_C_TESTS = {
        new GradeTestCase(60, 'C', "Grade C - Boundary minimum (60)"),
        new GradeTestCase(69.9f, 'C', "Grade C - Just below B (69.9)"),
        new GradeTestCase(65, 'C', "Grade C - Middle range (65)"),
        new GradeTestCase(62, 'C', "Grade C - Low in range (62)"),
        new GradeTestCase(68, 'C', "Grade C - High in range (68)"),
    };

    // Grade Test Data - Grade D (50-59)
    public static final GradeTestCase[] GRADE_D_TESTS = {
        new GradeTestCase(50, 'D', "Grade D - Boundary minimum (50)"),
        new GradeTestCase(59.9f, 'D', "Grade D - Just below C (59.9)"),
        new GradeTestCase(55, 'D', "Grade D - Middle range (55)"),
        new GradeTestCase(52, 'D', "Grade D - Low in range (52)"),
        new GradeTestCase(58, 'D', "Grade D - High in range (58)"),
    };

    // Grade Test Data - Grade E (< 50)
    public static final GradeTestCase[] GRADE_E_TESTS = {
        new GradeTestCase(49.9f, 'E', "Grade E - Just below D (49.9)"),
        new GradeTestCase(0, 'E', "Grade E - Minimum (0)"),
        new GradeTestCase(25, 'E', "Grade E - Middle below 50 (25)"),
        new GradeTestCase(10, 'E', "Grade E - Low value (10)"),
        new GradeTestCase(40, 'E', "Grade E - High value below 50 (40)"),
    };

    // Combined Grade Test Data (for parameterized tests)
    public static final GradeTestCase[] ALL_GRADE_TESTS = {
        // Grade A
        new GradeTestCase(85, 'A', "Boundary A (85)"),
        new GradeTestCase(90, 'A', "Middle A (90)"),
        new GradeTestCase(100, 'A', "Maximum A (100)"),
        // Grade B
        new GradeTestCase(70, 'B', "Boundary B (70)"),
        new GradeTestCase(75, 'B', "Middle B (75)"),
        new GradeTestCase(84.9f, 'B', "Upper B (84.9)"),
        // Grade C
        new GradeTestCase(60, 'C', "Boundary C (60)"),
        new GradeTestCase(65, 'C', "Middle C (65)"),
        new GradeTestCase(69.9f, 'C', "Upper C (69.9)"),
        // Grade D
        new GradeTestCase(50, 'D', "Boundary D (50)"),
        new GradeTestCase(55, 'D', "Middle D (55)"),
        new GradeTestCase(59.9f, 'D', "Upper D (59.9)"),
        // Grade E
        new GradeTestCase(0, 'E', "Minimum E (0)"),
        new GradeTestCase(25, 'E', "Middle E (25)"),
        new GradeTestCase(49.9f, 'E', "Upper E (49.9)"),
    };

    // Status Test Data - LULUS (>= 60)
    public static final StatusTestCase[] STATUS_LULUS_TESTS = {
        new StatusTestCase(60, "Lulus", "Status Lulus - Boundary (60)"),
        new StatusTestCase(70, "Lulus", "Status Lulus - Middle range (70)"),
        new StatusTestCase(85, "Lulus", "Status Lulus - High value (85)"),
        new StatusTestCase(100, "Lulus", "Status Lulus - Maximum (100)"),
        new StatusTestCase(60.5f, "Lulus", "Status Lulus - Decimal above 60 (60.5)"),
        new StatusTestCase(75, "Lulus", "Status Lulus - Grade B boundary (75)"),
    };

    // Status Test Data - TIDAK LULUS (< 60)
    public static final StatusTestCase[] STATUS_TIDAK_LULUS_TESTS = {
        new StatusTestCase(59.9f, "Tidak Lulus", "Status Tidak Lulus - Just below 60 (59.9)"),
        new StatusTestCase(59, "Tidak Lulus", "Status Tidak Lulus - One below (59)"),
        new StatusTestCase(50, "Tidak Lulus", "Status Tidak Lulus - Grade D (50)"),
        new StatusTestCase(0, "Tidak Lulus", "Status Tidak Lulus - Minimum (0)"),
        new StatusTestCase(30, "Tidak Lulus", "Status Tidak Lulus - Middle below 60 (30)"),
        new StatusTestCase(45, "Tidak Lulus", "Status Tidak Lulus - Near 50 (45)"),
    };

    // Combined Status Test Data
    public static final StatusTestCase[] ALL_STATUS_TESTS = {
        // Lulus
        new StatusTestCase(60, "Lulus", "Boundary Lulus (60)"),
        new StatusTestCase(70, "Lulus", "Middle Lulus (70)"),
        new StatusTestCase(100, "Lulus", "Maximum Lulus (100)"),
        new StatusTestCase(60.5f, "Lulus", "Decimal Lulus (60.5)"),
        // Tidak Lulus
        new StatusTestCase(59.9f, "Tidak Lulus", "Boundary Tidak Lulus (59.9)"),
        new StatusTestCase(50, "Tidak Lulus", "Middle Tidak Lulus (50)"),
        new StatusTestCase(0, "Tidak Lulus", "Minimum Tidak Lulus (0)"),
        new StatusTestCase(30, "Tidak Lulus", "Low Tidak Lulus (30)"),
    };
}
