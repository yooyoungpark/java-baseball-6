package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = computerNumber();
        playGame(computer);
        restartGame();
    }

    private static void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int reStart = Integer.parseInt(Console.readLine());
            if (reStart == 1) {
                List<Integer> restartComputer = computerNumber();
                playGame(restartComputer);
                restartGame();
            }
            if (reStart == 2) {
                System.out.println("게임종료");
            }
            if (reStart != 1 && reStart != 2){
                throw new IllegalArgumentException("1이나 2 를 입력하세요.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private static void playGame(List<Integer> computer) {
        while (true) {
            int[] inputGuessNumbers = playerNumber();
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
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
            if (strikeCount == 0 && ballCount == 0){
                System.out.println("낫싱");
            }
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    private static int[] playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] inputNum = Console.readLine().split("");
        if (inputNum.length != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
        int[] inputGuessNumbers = new int[inputNum.length];
        try {
            for (int i = 0; i < inputNum.length; i++) {
                inputGuessNumbers[i] = Integer.parseInt(inputNum[i]);
            }
            for (int guessNumber : inputGuessNumbers){
                if (guessNumber == 0){
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
        return inputGuessNumbers;
    }
}