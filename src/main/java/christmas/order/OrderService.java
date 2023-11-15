package christmas.order;

import christmas.event.EventService;
import christmas.menu.MenuItem;
import christmas.menu.MenuService;
import java.util.HashMap;

public class OrderService {
    private MenuService menuService;
    private HashMap<MenuItem, Integer> order;
    private EventService event;
    private static final String invalidOrderMsg = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public OrderService() {
        menuService = new MenuService();
        order = new HashMap<>();
        event = new EventService();
    }

    public void add(String name, Integer count) {
        MenuItem menuItem = menuService.order(name);
        if (order.keySet().contains(menuItem))
            throw new IllegalArgumentException(invalidOrderMsg);
        if (menuItem == null)
            throw new IllegalArgumentException(invalidOrderMsg);
        if (count < 1)
            throw new IllegalArgumentException(invalidOrderMsg);
        order.put(menuItem, count);
    }

    public void addByMap(HashMap<String, Integer> order) {
        try {
            for (String name : order.keySet()) {
                add(name, order.get(name));
            }
            checkOrder();
        }
        catch (IllegalArgumentException ex) {
            this.order.clear();
            throw ex;
        }
    }

    public HashMap<MenuItem, Integer> getOrder() {
        return order;
    }

    public Integer getTotalPrice() {
        Integer totalPrice = 0;
        for (MenuItem menuItem : order.keySet()) {
            totalPrice += order.get(menuItem) * menuItem.getPrice();
        }
        return totalPrice;
    }

    public Integer getCategoryCount(String category) {
        Integer count = 0;
        for (MenuItem menuItem : order.keySet()) {
            if (menuItem.getCategory().equals(category)) {
                count += order.get(menuItem);
            }
        }
        return count;
    }

    /*
        음료만 주문 시, 주문할 수 없습니다.
        메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
     */
    private void checkOrder() {
        Integer totalCount = 0;
        boolean isOnlyBeverage = true;
        for (Integer count : order.values()) {
            totalCount += count;
        }
        for (MenuItem menuItem : order.keySet()) {
            if (!menuItem.getCategory().equals("음료")) {
                isOnlyBeverage = false;
            }
        }
        if (totalCount > 20 || isOnlyBeverage)
            throw new IllegalArgumentException(invalidOrderMsg);
    }
}
