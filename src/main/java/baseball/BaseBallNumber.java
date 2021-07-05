package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BaseBallNumber {
    private List<Ball> balls;

    public BaseBallNumber(List<Integer> balls) {
        if(balls.size()!=3)
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        
        if(checkSize(balls)!=3)
            throw new IllegalArgumentException("서로 다른 숫자로 이루어진 숫자를 입력하세요");

        this.balls = mapToBall(balls);

    }

    private List<Ball> mapToBall(List<Integer> balls) {
        List<Ball> result = new ArrayList<>();

        for(int i=0;i<balls.size();i++){
            result.add(new Ball(i+1,balls.get(i)));
        }
        return result;
    }

    private int checkSize(List<Integer> balls){
        return new HashSet<>(balls).size();
    }

    public BallStatus judge(Ball ball){
        return balls.stream()
                .map(ball::compare)
                .filter(x-> x != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }


}
