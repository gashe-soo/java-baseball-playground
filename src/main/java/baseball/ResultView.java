package baseball;

public class ResultView {

    public void printResult(PlayResult result){
        System.out.println(result.toString());
    }

    public void notifyGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
