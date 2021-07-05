package baseball;

public class Ball {
    public Ball(int pos, int no) {
        if(no>9 || no<1)
            throw new IllegalArgumentException("숫자는 1-9사이입니다.");
    }
}
