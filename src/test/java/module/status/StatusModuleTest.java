package module.status;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusModuleTest {

    private final StatusModule statusModule = new StatusModule();

    @Test
    void shouldReturnLulusForScoresAtOrAbove60() {
        assertEquals("Lulus", statusModule.getStatus(60));
        assertEquals("Lulus", statusModule.getStatus(100));
    }

    @Test
    void shouldReturnTidakLulusForScoresBelow60() {
        assertEquals("Tidak Lulus", statusModule.getStatus(59.99));
        assertEquals("Tidak Lulus", statusModule.getStatus(0));
    }

    @Test
    void shouldHandleEdgeCasesAroundBoundary() {
        assertEquals("Tidak Lulus", statusModule.getStatus(59.0));
        assertEquals("Lulus", statusModule.getStatus(60.0));
    }
}
