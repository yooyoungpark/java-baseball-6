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
        String[] inputNumber = Console.readLine().split("");
        int[] inputGuessNumber = new int[inputNumber.length];
        try {
            for (int i = 0; i < inputNumber.length; i++) {
                inputGuessNumber[i] = Integer.parseInt(inputNumber[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        System.out.println(Arrays.toString(inputGuessNumber));
    }

}
