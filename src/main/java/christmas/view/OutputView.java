package christmas.view;

public class OutputView {
    private static final String helloMsg = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String askDayMsg = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public void hello() {
        System.out.println(helloMsg);
    }

    public void printAskDay() {
        System.out.println(askDayMsg);
    }
}
