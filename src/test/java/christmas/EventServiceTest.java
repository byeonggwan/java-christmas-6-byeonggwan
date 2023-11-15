package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.event.EventService;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventServiceTest {

    private EventService eventService;

    @BeforeEach
    void setUp() {
        eventService = new EventService();
    }

    @DisplayName("10000원 이하 이벤트 미적용")
    @Test
    void thresholdTest() {
        HashMap<String, Integer> appliedEvents = eventService.apply(25, 999, 999, 9999);

        assertEquals(0, appliedEvents.get("크리스마스 디데이 할인"));
        assertEquals(0, appliedEvents.get("평일 할인"));
        assertEquals(0, appliedEvents.get("주말 할인"));
        assertEquals(0, appliedEvents.get("특별 할인"));
        assertEquals(0, appliedEvents.get("증정 이벤트"));
    }

    @DisplayName("크리스마스 할인 적용 - 12월 1일부터 25일까지")
    @Test
    void applyChristmasDiscount() {
        HashMap<String, Integer> appliedEvents = eventService.apply(5, 1, 1, 50000);

        assertEquals(900 + 100 * 5, appliedEvents.get("크리스마스 디데이 할인"));
    }

    @DisplayName("평일 할인 적용")
    @Test
    void applyWeekdayDiscount() {
        HashMap<String, Integer> appliedEvents = eventService.apply(3, 2, 1, 50000);

        assertEquals(2023 * 2, appliedEvents.get("평일 할인"));
    }

    @DisplayName("주말 할인 적용")
    @Test
    void applyWeekendDiscount() {
        HashMap<String, Integer> appliedEvents = eventService.apply(1, 1, 2, 50000);

        assertEquals(2023 * 2, appliedEvents.get("주말 할인"));
    }

    @DisplayName("특별 할인 적용 - 25일, 일요일, 평일")
    @Test
    void applySpecialDiscount() {
        HashMap<String, Integer> appliedEvents1 = eventService.apply(25, 1, 1, 50000);
        HashMap<String, Integer> appliedEvents2 = eventService.apply(3, 1, 1, 50000);

        assertEquals(1000, appliedEvents1.get("특별 할인"));
        assertEquals(1000, appliedEvents2.get("특별 할인"));
    }

    @DisplayName("증정 이벤트 적용 - 총 주문 금액 120,000원 이상")
    @Test
    void applyGiftEvent() {
        HashMap<String, Integer> appliedEvents = eventService.apply(5, 2, 2, 130000);

        assertEquals(25000, appliedEvents.get("증정 이벤트"));
    }

    @DisplayName("모든 이벤트 미적용")
    @Test
    void noEventApplied() {
        HashMap<String, Integer> appliedEvents = eventService.apply(26, 0, 2, 110000);

        assertEquals(0, appliedEvents.get("크리스마스 디데이 할인"));
        assertEquals(0, appliedEvents.get("평일 할인"));
        assertEquals(0, appliedEvents.get("주말 할인"));
        assertEquals(0, appliedEvents.get("특별 할인"));
        assertEquals(0, appliedEvents.get("증정 이벤트"));
    }
}