package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.order.OrderService;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @DisplayName("주문 추가 - 중복 주문")
    @Test
    void addDuplicateOrder() {
        orderService.add("양송이수프", 2);

        assertThrows(IllegalArgumentException.class, () ->
                orderService.add("양송이수프", 3)
        );
    }

    @DisplayName("주문 추가 - 유효하지 않은 메뉴명")
    @Test
    void addInvalidMenuName() {
        assertThrows(IllegalArgumentException.class, () ->
                orderService.add("유효하지않은메뉴", 1)
        );
    }

    @DisplayName("주문 추가 - 음수 수량")
    @Test
    void addNegativeCount() {
        assertThrows(IllegalArgumentException.class, () ->
                orderService.add("양송이수프", -1)
        );
    }

    @DisplayName("getTotalPrice - 주문이 없을 때")
    @Test
    void getTotalPriceNoOrder() {
        assertEquals(0, orderService.getTotalPrice());
    }

    @DisplayName("checkOrder - 음료만 주문")
    @Test
    void checkOrderOnlyBeverage() {
        HashMap<String, Integer> orderMap = new HashMap<>();
        orderMap.put("제로콜라", 2);
        orderMap.put("레드와인", 1);

        assertThrows(IllegalArgumentException.class, () ->
                orderService.addByMap(orderMap)
        );
    }

    @DisplayName("checkOrder - 주문 20개 초과")
    @Test
    void checkOrderValidOrder() {
        HashMap<String, Integer> orderMap = new HashMap<>();
        orderMap.put("제로콜라", 2);
        orderMap.put("레드와인", 1);
        orderMap.put("티본스테이크", 18);

        assertThrows(IllegalArgumentException.class, () ->
                orderService.addByMap(orderMap)
        );
    }

    @DisplayName("getTotalPrice - 유효한 주문")
    @Test
    void getTotalPriceValidOrder() {
        orderService.add("양송이수프", 2);
        orderService.add("초코케이크", 1);

        assertEquals(27000, orderService.getTotalPrice());
    }
}
