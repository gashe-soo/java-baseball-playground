package baseball;

import java.util.Objects;

public class Ball {
    private int pos;
    private int no;
    public Ball(int pos, int no) {
        if(no>9 || no<1)
            throw new IllegalArgumentException("숫자는 1-9사이입니다.");
        this.pos = pos;
        this.no = no;
    }

    public BallStatus compare(Ball ball) {
        if(this.equals(ball))
            return BallStatus.STRIKE;
        if(ball.matchNumber(this.no))
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    public boolean matchNumber(int no){
        return this.no == no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return pos == ball.pos && no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, no);
    }
}
