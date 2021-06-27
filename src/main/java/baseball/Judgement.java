package baseball;

public class Judgement {

    private int ball;
    private int strike;

    public Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (this.strike == 0 && this.ball == 0)
            return "nothing";
        if (this.strike == 0)
            return this.ball + "ball";
        if (this.ball == 0)
            return this.strike + "strike";
        return this.ball + "ball " + this.strike + "strike";
    }
}
