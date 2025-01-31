# 자바 숫자 야구 게임
저는 Java가 처음입니다. 프리코스 시작 전까지 웹 프론트엔드(Html, CSS, Javascript) 유튜브를 보면서    
아기가 옹알이하는 정도로 해봤고, 정말 창피하지만, 저는 List<integer>조차 모른 상태였습니다.   
우테코 프리코스 6기 시작하면서 Java를 처음 공부해 보고 개발이 처음이기 때문에    
저는 제가 할 수 있는 상황에서 한 단계 한 단계 성장하는 개발자가 되기 위해 최선을 다해 노력했습니다.   
다른 사람들과 비교하지 말고 내가 할 수 있는 것부터 하지 싶어 일단 기본 문법에 익숙해지기로 스스로 약속했고,    
공부한 내용은 벨로그에 하나하나 정리해 나가고 있습니다. 이를 통해 기본적인 개념과 자료 구조에 대해서 배울 수 있었습니다.   
이번 1주 차 미션을 통해 비전공에 완전한 백지상태였던 제가 하나하나 찾아보고 배우며 알게 된 것들을 나열해 보겠습니다.
1. 개발 환경 세팅
    - Git 사용 방법
    - 인텔리제이 단축키 사용
    - 구글 자바 컨벤션 적용
2. 자바 기본 문법
    - 클래스 선언과 인스턴스 생성 방법
    - 생성자와 인스턴스 변수
    - 접근 제어자, final
    - 예외 선언과 예외 처리

저는 다른 크루들에 비해 갈 길이 멀지만   
그만큼 배울 것이 많기 때문에 앞으로 성장 할 수밖에 없다고 생각하며 기쁜 마음으로 몰입하고 있습니다.    
이번에 전체 지원자가 4500명이 넘었다고 들었는데 많은 사람과 함께 하는 만큼 배움과 성장도 클 것이라 기대되고,   
프리코스 커뮤니티를 통해 코드 리뷰와 토론도 해보면서 함께 성장해 나가는 즐거움을 동력으로   
한 주 한 주 더욱 발전된 모습을 보여주겠습니다!!

## ⚾️ 기능 명세
- [x] 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
- [x] 사용자는 각 자릿수가 서로 다른 3자릿수를 예상 정답으로 입력한다.
- [x] 사용자의 점수를 계산한다.
    - [x] 같은 수, 같은 자리면 스트라이크로 처리한다.
    - [x] 같은 수지만 다른 자리면 볼로 처리한다.
    - [x] 처리된 스트라이크, 볼 개수를 출력한다. 단, 스트라이크 볼 갯수가 0일 경우 낫싱을 출력한다.
- [x] 3자릿수를 모두 맞추면 게임은 종료된다.
- [x] 종료 후 재시작이나 완전 종료를 선택할 수 있다.
    - [x] 1을 입력하면 재시작/2를 입력하면 종료가 된다.
- [x] 사용자가 잘못된 값을 입력했을 시, IllegalArgumentException을 발생시킨다.
    - [x] 사용자가 중복이 있는 수를 입력했을 경우
    - [x] 사용자의 예상 정답이 숫자가 3개가 아닌 경우 또는 숫자가 아닌 다른 문자를 입력했을 경우
    - [x] 종료 후 1이나 2가 아닌 값을 입력했을 경우

### 입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
