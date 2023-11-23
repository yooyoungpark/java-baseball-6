package baseball;

public class OutputView {
    public static final int GAME_OVER_NUMBER = 2;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void closeGame(int inputGameOverNumberOrGameRestartNumber) {
        if (inputGameOverNumberOrGameRestartNumber == GAME_OVER_NUMBER) {
            System.out.println("게임종료");
        }
    }
}
