package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallTest {

    @Test
    void 볼_범위_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Ball(1,10));
        assertThrows(IllegalArgumentException.class, () -> new Ball(1,0));
        assertDoesNotThrow(()-> new Ball(1,1));
        assertDoesNotThrow(()-> new Ball(1,9));
    }

}
