package christmas.view;

import christmas.menu.MenuItem;
import java.util.HashMap;

public class OutputView {
    private static final String helloMsg = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String askDayMsg = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String askOrderMsg = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public void hello() {
        System.out.println(helloMsg);
    }

    public void printAskDay() {
        System.out.println(askDayMsg);
    }

    public void printAskOrder() {
        System.out.println(askOrderMsg);
    }

    public void printPreview(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public void printOrder(HashMap<MenuItem, Integer> order) {
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : order.keySet()) {
            System.out.println(menuItem.getName() + " " + order.get(menuItem) + "개");
        }
        System.out.println("");
    }
}
