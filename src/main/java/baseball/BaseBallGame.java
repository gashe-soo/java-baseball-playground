package baseball;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseBallGame {

    private InputView input;
    private ResultView result;
    private BaseBallNumber number;


    public BaseBallGame(InputView input, ResultView result) {
        this.input = input;
        this.result = result;
    }

    public void start() throws IOException {
        this.number = new BaseBallNumber(NumberGenerator.generate());
        play();
    }

    private void play() throws IOException {
        PlayResult playResult = new PlayResult();
        try{
            int[] guess = Arrays.stream(input.enterGuess().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            BaseBallNumber baseBallNumber = new BaseBallNumber(Arrays.stream(guess).boxed().collect(Collectors.toList()));

            judgeBall(guess, playResult);

            result.printResult(playResult);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
            if (playResult.isEnd()) {
                end();
                return;
            }
            play();
        }
    }

    private void judgeBall(int[] guess, PlayResult playResult) {
        for (Ball ball : mapToList(guess)) {
            playResult.add(number.judge(ball));
        }
    }

    private void end() throws IOException {
        result.notifyGameEnd();
        if (input.enterGameSignal().equals("1"))
            start();
    }

    private List<Ball> mapToList(int[] guess) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(new Ball(i + 1, guess[i]));
        }
        return result;
    }

}
