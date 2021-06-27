import baseball.BaseBallGame;
import baseball.BaseBallReferee;
import baseball.RandomNumberGenerator;

import java.io.IOException;

public class playBaseBall {
    public static void main(String[] args) {
        try{
            new BaseBallGame(new BaseBallReferee(), new RandomNumberGenerator(), "3strike").start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
