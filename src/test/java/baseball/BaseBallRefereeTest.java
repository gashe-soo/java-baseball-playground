package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallRefereeTest {
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new BaseBallReferee();
    }

    @ParameterizedTest
    @CsvSource({
            "125, 125, 3strike",
            "123, 125, 2strike",
            "123, 145, 1strike",
            "321, 132, 3ball",
            "321, 135, 2ball",
            "123, 451, 1ball",
            "123, 152, 1ball 1strike",
            "123, 132, 2ball 1strike",
            "125, 346, nothing"
    })
    void 판정_성공(int answer, int guess, String judgement){
        assertEquals(judgement, referee.judge(answer,guess));
    }

}