package baseball;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseBallGame {

    private final Referee referee;
    private final NumberGenerator numberGenerator;
    private final String answer;
    private int number;

    public BaseBallGame(Referee referee, NumberGenerator numberGenerator, String answer) {
        this.referee = referee;
        this.numberGenerator = numberGenerator;
        this.answer = answer;

    }

    private void play() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해 주세요 : ");

        int guess = Integer.parseInt(reader.readLine());

        // 과연 generator에게 검증 역할을 맡기는 게 올바른가? 2가지의 역할?
        if(!numberGenerator.isValid(guess)){
            System.out.println("잘못된 숫자입니다.");
            play();
            return;
        }
        String result = referee.judge(this.number, guess);

        System.out.println(result);

        if (result.equals(this.answer)) {
            end();
            return;
        }
        play();
    }

    private void end() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        if (input == 1) {
            start();
        }

        return;
    }

    public void start() throws IOException {
        this.number = numberGenerator.generate();
        System.out.println(this.number);
        play();
    }


}
