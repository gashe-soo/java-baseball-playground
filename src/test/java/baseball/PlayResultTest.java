package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayResultTest {

    @Test
    void 게임_종료_확인(){
        PlayResult playResult = new PlayResult();
        for(int i=0;i<3;i++){
            playResult.add(BallStatus.STRIKE);
        }

        assertEquals(playResult.isEnd(), true);
    }
}
