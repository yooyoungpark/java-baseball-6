package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        System.out.print("숫자를 입력해주세요 : ");
        String[] inputNum = Console.readLine().split("");
        int[] inputGuessNumbers = new int[inputNum.length];
        try {
            for (int i = 0; i < inputNum.length; i++) {
                inputGuessNumbers[i] = Integer.parseInt(inputNum[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        //System.out.println(Arrays.toString(inputGuessNumbers));

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
        System.out.println(strikeCount + "스트라이크");
        System.out.println(ballCount + "볼");


        if (inputGuessNumbers.length != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
        for (int guessNumber : inputGuessNumbers) {
            if (guessNumber == 0) {
                throw new IllegalArgumentException("1에서 9까지의 수를 입력해주세요.");
            }
        }

    }
}