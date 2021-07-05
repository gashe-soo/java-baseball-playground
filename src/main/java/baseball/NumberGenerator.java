package baseball;

import java.util.*;

public class NumberGenerator {

    public static List<Integer> generate(){
        Random random =  new Random();
        Set<Integer> result = new HashSet<>();

        while(result.size()<3){
            result.add(random.nextInt(9)+1);
        }
        return new ArrayList<>(result);
    }
}
