package baseball;

public class BaseBallReferee implements Referee {
    @Override
    public String judge(int answer, int guess) {
        int strikeCount = 0;
        int ballCount = 0;
        int[] answerCount = writePlaceIndex(answer);
        int[] guessCount = writePlaceIndex(guess);

        for (int index = 1; index < 10; index++) {
            strikeCount += checkStrike(answerCount, guessCount, index);
            ballCount += checkBall(answerCount, guessCount, index);
        }

        return new Judgement(strikeCount, ballCount).toString();
    }


    private int checkStrike(int[] answer, int[] guess, int index) {
        if (answer[index] != 0 && answer[index] == guess[index])
            return 1;
        return 0;
    }

    private int checkBall(int[] answer, int[] guess, int index) {
        if (answer[index] != 0 && guess[index] != 0 && answer[index] != guess[index])
            return 1;
        return 0;
    }


    private int[] writePlaceIndex(int value) {
        int[] count = new int[10];

        int place = 1;

        while (value > 0) {
            int onesPlace = value % 10;
            count[onesPlace] = place++;
            value /= 10;
        }
        return count;
    }

}
