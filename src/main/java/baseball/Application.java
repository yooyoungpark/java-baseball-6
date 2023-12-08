package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int DIGIT_NUMBER = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int GAME_RESTART_NUMBER = 1;
    public static final int GAME_OVER_NUMBER = 2;

    public static void main(String[] args) {
        while (true) {
            OutputView.startGame();
            List<Integer> computerNumbers = computerNumber();
            playGame(computerNumbers);
            if (InputView.reStartOrCloseGame() == GAME_OVER_NUMBER) {
                OutputView.closeGame();
                break;
            }
        }
    }

    public static void playGame(List<Integer> computerNumbers) {
        while (true) {
            List<Integer> inputGuessNumbers = InputView.playerNumber();
            int strikeCount = calculateStrikeCount(computerNumbers, inputGuessNumbers);
            int ballCount = calculateBallCount(computerNumbers, inputGuessNumbers);
            OutputView.printGameCount(ballCount, strikeCount);
            if (strikeCount == DIGIT_NUMBER) {
                OutputView.endGame();
                break;
            }
        }
    }

    private static int calculateStrikeCount(List<Integer> computerNumbers, List<Integer> inputGuessNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            if (computerNumbers.contains(inputGuessNumbers.get(i))) {
                if (computerNumbers.get(i) == inputGuessNumbers.get(i)) {
                    strikeCount++;
                }
            }
        }
        return strikeCount;
    }

    private static int calculateBallCount(List<Integer> computerNumbers, List<Integer> inputGuessNumbers) {
        int ballCount = 0;
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            if (computerNumbers.contains(inputGuessNumbers.get(i))) {
                if (computerNumbers.get(i) != inputGuessNumbers.get(i)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public static List<Integer> computerNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}