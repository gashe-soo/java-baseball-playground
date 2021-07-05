package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseBallNumberTest {

    @Test
    void 숫자_3개_포함() {
        assertThrows(IllegalArgumentException.class, () -> new BaseBallNumber(Arrays.asList(1, 2, 3, 4)));
        assertThrows(IllegalArgumentException.class, () -> new BaseBallNumber(Arrays.asList(1, 4)));
        assertThrows(IllegalArgumentException.class, () -> new BaseBallNumber(Arrays.asList(1, 4, 4)));
        assertDoesNotThrow(() -> new BaseBallNumber(Arrays.asList(1, 2, 3)));
    }

    @Test
    void 모두_다른_1_9사이의_숫자() {
        assertThrows(IllegalArgumentException.class, () -> new BaseBallNumber(Arrays.asList(1, 2, 0)));
    }

}
