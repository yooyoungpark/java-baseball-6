package baseball;

import static baseball.Application.DIGIT_NUMBER;
import static baseball.Application.GAME_RESTART_NUMBER;
import static baseball.Application.GAME_OVER_NUMBER;
import static baseball.Application.MIN_NUMBER;
import static baseball.Application.MAX_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<Integer> playerNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputNum = Console.readLine().split("");
            List<Integer> inputGuessNumbers = createNumbers(inputNum);
            checkNumberSize(inputGuessNumbers);
            checkNumberRange(inputGuessNumbers);
            checkDuplicated(inputGuessNumbers);
            return inputGuessNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return playerNumber();
        }
    }

    private static void checkDuplicated(List<Integer> inputGuessNumbers) {
        for (int i = 0; i < inputGuessNumbers.size(); i++) {
            for (int j = i + 1; j < inputGuessNumbers.size(); j++) {
                if (inputGuessNumbers.get(i) == inputGuessNumbers.get(j)) {
                    throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다.");
                }
            }
        }
    }

    private static void checkNumberRange(List<Integer> inputGuessNumbers) {
        for (int number : inputGuessNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(MIN_NUMBER + "에서 " + MAX_NUMBER + "까지의 수를 입력해 주세요.");
            }
        }
    }

    private static void checkNumberSize(List<Integer> inputGuessNumbers) {
        if (inputGuessNumbers.size() != DIGIT_NUMBER) {
            throw new IllegalArgumentException(DIGIT_NUMBER + "자리 수를 입력해 주세요.");
        }
    }

    public static List<Integer> createNumbers(String[] inputNum) {
        try {
            List<Integer> inputGuessNumbers = new ArrayList<>();
            for (int i = 0; i < inputNum.length; i++) {
                int toNumber = Integer.parseInt(inputNum[i]);
                inputGuessNumbers.add(toNumber);
            }
            return inputGuessNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static int reStartOrCloseGame() {
        try {
            System.out.println("게임을 새로 시작하려면 " + GAME_RESTART_NUMBER + "," + " 종료하려면 " + GAME_OVER_NUMBER + "를 입력하세요.");
            int input = inputNumber();
            if (input != GAME_RESTART_NUMBER && input != GAME_OVER_NUMBER) {
                throw new IllegalArgumentException("1이나 2 를 입력해 주세요.");
            }
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return reStartOrCloseGame();
        }
    }

    private static int inputNumber() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
