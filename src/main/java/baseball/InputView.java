package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static final int DIGIT_NUMBER = 3;
    public static final int GAME_RESTART_NUMBER = 1;
    public static final int GAME_OVER_NUMBER = 2;

    public static int[] playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] inputNum = Console.readLine().split("");
        int[] inputGuessNumbers = new int[inputNum.length];
        try {
            for (int i = 0; i < inputNum.length; i++) {
                inputGuessNumbers[i] = Integer.parseInt(inputNum[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
        if (inputGuessNumbers.length != DIGIT_NUMBER) {
            throw new IllegalArgumentException(DIGIT_NUMBER + "자리의 수를 입력해주세요.");
        }
        for (int guessNumber : inputGuessNumbers) {
            if (guessNumber == 0) {
                throw new IllegalArgumentException("1에서 9까지의 수를 입력하세요.");
            }
        }
        for (int i = 0; i < inputGuessNumbers.length; i++) {
            for (int j = i + 1; j < inputGuessNumbers.length; j++) {
                if ((inputGuessNumbers[i]) == (inputGuessNumbers[j])) {
                    throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다.");
                }
            }
        }
        return inputGuessNumbers;
    }

    public static void reStartOrCloseGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int inputGameOverNumberOrGameRestartNumber = Integer.parseInt(Console.readLine());
            reStartGame(inputGameOverNumberOrGameRestartNumber);
            OutputView.closeGame(inputGameOverNumberOrGameRestartNumber);
            if (inputGameOverNumberOrGameRestartNumber != GAME_RESTART_NUMBER
                    && inputGameOverNumberOrGameRestartNumber != GAME_OVER_NUMBER) {
                throw new IllegalArgumentException("1이나 2 를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private static void reStartGame(int inputGameOverNumberOrGameRestartNumber) {
        if (inputGameOverNumberOrGameRestartNumber == GAME_RESTART_NUMBER) {
            List<Integer> restartComputer = Application.computerNumber();
            Application.playGame(restartComputer);
            reStartOrCloseGame();
        }
    }
}
