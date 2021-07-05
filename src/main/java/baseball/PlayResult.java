package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;

    public void add(BallStatus status) {
        if(status==BallStatus.STRIKE){
            strike++;
            return;
        }
        if(status == BallStatus.BALL){
            ball++;
        }
    }

    @Override
    public String toString() {
        if(strike==0 && ball==0)
            return "낫싱";
        if(strike==0)
            return ball+"볼";
        if(ball==0)
            return strike+"스트라이크";

        return ball+"볼 "+strike+"스트라이크";
    }
}
