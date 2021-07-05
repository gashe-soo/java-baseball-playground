package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private BufferedReader reader;

    public InputView(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String enterGuess() throws IOException {
        System.out.print("숫자를 입력해 주세요: ");
        return reader.readLine();
    }

    public String enterGameSignal() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return reader.readLine();
    }

}
