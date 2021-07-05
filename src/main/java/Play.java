import baseball.BaseBallGame;
import baseball.InputView;
import baseball.ResultView;

public class Play {
    public static void main(String[] args) {
        try{
            new BaseBallGame(new InputView(), new ResultView()).start();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
