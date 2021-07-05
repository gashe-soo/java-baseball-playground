package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp(){
        ball = new Ball(1,4);
    }

    @Test
    void 볼_범위_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Ball(1,10));
        assertThrows(IllegalArgumentException.class, () -> new Ball(1,0));
        assertDoesNotThrow(()-> new Ball(1,1));
        assertDoesNotThrow(()-> new Ball(1,9));
    }

    @Test
    void 낫싱(){
        assertThat(ball.compare(new Ball(2,5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 스트라이크(){
        assertThat(ball.compare(new Ball(1,4))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼(){
        assertThat(ball.compare(new Ball(2,4))).isEqualTo(BallStatus.BALL);
    }

}
