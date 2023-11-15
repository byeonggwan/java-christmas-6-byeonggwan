package christmas.view;

import christmas.event.Badge;
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

    public void printTotalPrice(Integer totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n\n", totalPrice);
    }

    public void printGift(Integer totalPrice) {
        System.out.println("<증정 메뉴>");
        String gift = "없음";
        if (totalPrice >= 120000) {
            gift = "샴페인 1개";
        }
        System.out.println(gift);
        System.out.println("");
    }

    public void printDisc(HashMap<String, Integer> appliedEvents) {
        System.out.println("<혜택 내역>");
        Integer count = 0;
        for (String name : appliedEvents.keySet()) {
            Integer discount = appliedEvents.get(name);
            if (discount != 0) {
                count += 1;
                System.out.printf(name + ": -%,d원\n", discount);
            }
        }
        if (count == 0) {
            System.out.println("없음");
        }
        System.out.println("");
    }

    public void printTotalDisc(Integer totalDiscount) {
        System.out.println("<총혜택 금액>");
        if (totalDiscount == 0) {
            System.out.println("0원");
        }
        if (totalDiscount != 0) {
            System.out.printf("-%,d원\n", totalDiscount);
        }
        System.out.println("");
    }

    public void printLastPrice(Integer totalPrice, Integer totalDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", totalPrice - totalDiscount);
        System.out.println("");
    }

    public void printBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
    }
}
