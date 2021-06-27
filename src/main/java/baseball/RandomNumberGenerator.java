package baseball;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random;
    private int bound = 1000;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        int number = random.nextInt(this.bound);

        if (isValid(number))
            return number;
        return generate();
    }

    @Override
    public boolean isValid(int value) {
        return isRange(value) && isDistinct(value) && !containZero(value);
    }

    private boolean isRange(int value) {
        return value >= 123 && value <= 987;
    }

    private boolean isDistinct(int value) {
        int one = value % 10;
        int ten = (value / 10) % 10;
        int hundred = value / 100;

        if (one != ten && ten != hundred && hundred != one)
            return true;
        return false;
    }

    private boolean containZero(int value) {
        int one = value % 10;
        int ten = (value / 10) % 10;
        int hundred = value / 100;

        if (one == 0 || ten == 0 || hundred == 0)
            return true;
        return false;
    }
}
