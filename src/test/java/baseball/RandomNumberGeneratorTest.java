package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp(){
        numberGenerator = new RandomNumberGenerator();
    }

    @RepeatedTest(10)
    void 생성한_숫자_3자리(){
        int number = numberGenerator.generate();

        assertEquals(true, isRange(number));
    }

    @RepeatedTest(10)
    void 모두_다른_숫자(){
        int number = numberGenerator.generate();
        int one = number %10;
        int ten = (number/10)%10;
        int hun = (number/100);

        assertEquals(false, isSame(one,ten) || isSame(one,hun)|| isSame(ten,hun));

    }

    @RepeatedTest(10)
    void 자연수_3자리_숫자(){
        int number = numberGenerator.generate();
        int one = number %10;
        int ten = (number/10)%10;
        int hun = (number/100);

        assertEquals(true, isNotZero(one) && isNotZero(ten)&&isNotZero(hun));
    }


    boolean isSame(int a, int b){
        return a==b;
    }

    boolean isNotZero(int a){
        return a!=0;
    }

    boolean isRange(int number){
        return number>=100 && number<1000;
    }

}