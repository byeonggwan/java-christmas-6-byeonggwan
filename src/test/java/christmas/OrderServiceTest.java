package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.order.OrderService;
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
}
