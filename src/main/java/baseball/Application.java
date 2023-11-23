package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int GAME_RESTART_NUMBER = 1;
    public static final int GAME_OVER_NUMBER = 2;
    public static final int DIGIT_NUMBER = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;


    public static void main(String[] args) {
        OutputView.startGame();
        List<Integer> computer = computerNumber();
        playGame(computer);
        InputView.reStartOrCloseGame();
    }

    public static void playGame(List<Integer> computer) {
        while (true) {
            int[] inputGuessNumbers = InputView.playerNumber();
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < DIGIT_NUMBER; i++) {
                if (computer.contains(inputGuessNumbers[i])) {
                    if (computer.get(i) == inputGuessNumbers[i]) {
                        strikeCount += 1;
                    }
                    if (computer.get(i) != inputGuessNumbers[i]) {
                        ballCount += 1;
                    }
                }
            }
            System.out.print(ballCount + "볼 ");
            System.out.println(strikeCount + "스트라이크");
            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            }
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}