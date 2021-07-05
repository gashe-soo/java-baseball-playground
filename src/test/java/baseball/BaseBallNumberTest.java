package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseBallNumberTest {

    private BaseBallNumber num;

    @BeforeEach
    void setUp(){
        num = new BaseBallNumber(Arrays.asList(1,2,3));
    }

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



    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 3스트라이크",
            "1, 2, 4, 2스트라이크",
            "1, 4, 5, 1스트라이크",
            "3, 1, 2, 3볼",
            "2, 1, 4, 2볼",
            "3, 4, 5, 1볼",
            "3, 2, 1, 2볼 1스트라이크",
            "1, 3, 5, 1볼 1스트라이크",
            "4, 5, 6, 낫싱"
    })
    void 판정_성공(int a, int b, int c, String result){
        int[] arr = {a,b,c};
        PlayResult playResult = new PlayResult();
        for(int i=0;i<3;i++){
            playResult.add(num.judge(new Ball(i+1,arr[i])));
        }
        assertThat(playResult.toString()).isEqualTo(result);
    }



}
