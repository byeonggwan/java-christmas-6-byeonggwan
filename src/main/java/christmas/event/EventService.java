package christmas.event;

import java.util.HashMap;

public class EventService {
    private static final String christmasMsg = "크리스마스 디데이 할인";
    private static final String weekdayMsg = "평일 할인";
    private static final String weekendMsg = "주말 할인";
    private static final String specialMsg = "특별 할인";
    private static final Integer specialPrice = 1000;
    private static final String giftMsg = "증정 이벤트";
    private static final Integer giftPrice = 25000;

    private static final Integer year = 2023;
    private static final Integer threshold = 10000;

    public EventService() {
    }

    public HashMap<String, Integer> apply(Integer day, Integer dessertCount, Integer mainMenuCount, Integer totalPrice) {
        HashMap<String, Integer> appliedEvents = new HashMap<>();
        appliedEvents.put(christmasMsg, christmasDisc(day, totalPrice));
        appliedEvents.put(weekdayMsg, weekdayDisc(day, dessertCount, totalPrice));
        appliedEvents.put(weekendMsg, weekendDisc(day, mainMenuCount, totalPrice));
        appliedEvents.put(specialMsg, specialDisc(day, totalPrice));
        appliedEvents.put(giftMsg, giftEvent(totalPrice));
        return appliedEvents;
    }

    private Integer christmasDisc(Integer day, Integer totalPrice) {
        if (day >= 1 && day <= 25 && totalPrice >= threshold) {
            return 900 + 100 * day;
        }
        return 0;
    }

    private Integer weekdayDisc(Integer day, Integer dessertCount, Integer totalPrice) {
        Integer dayOfWeek = (day-1) % 7;
        if (dayOfWeek >= 2 && totalPrice >= threshold) {
            return dessertCount * year;
        }
        return 0;
    }

    private Integer weekendDisc(Integer day, Integer mainMenuCount, Integer totalPrice) {
        Integer dayOfWeek = (day-1) % 7;
        if (dayOfWeek < 2 && totalPrice >= threshold) {
            return mainMenuCount * year;
        }
        return 0;
    }

    private Integer specialDisc(Integer day, Integer totalPrice) {
        Integer dayOfWeek = (day-1) % 7;
        if ((day == 25 || dayOfWeek == 2) && totalPrice >= threshold) {
            return specialPrice;
        }
        return 0;
    }

    private Integer giftEvent(Integer totalPrice) {
        if (totalPrice >= 120000) {
            return giftPrice;
        }
        return 0;
    }

    public Integer getTotalDiscount(Integer day, Integer dessertCount, Integer mainMenuCount, Integer totalPrice) {
        HashMap<String, Integer> appliedEvents = apply(day, dessertCount, mainMenuCount, totalPrice);
        Integer totalDiscount = 0;
        for (Integer discount : appliedEvents.values()) {
            totalDiscount += discount;
        }
        return totalDiscount;
    }

    public Integer getTotalDiscountExceptGift(Integer day, Integer dessertCount, Integer mainMenuCount, Integer totalPrice) {
        Integer totalDiscount = getTotalDiscount(day, dessertCount, mainMenuCount, totalPrice);
        if (totalPrice >= 120000) {
            totalDiscount -= giftPrice;
        }
        return totalDiscount;
    }
}
