package baseball;

public class OutputView {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void closeGame() {
        System.out.println("게임 완전 종료");
    }

    public static void printGameCount(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼 ");
        }
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    public static void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
