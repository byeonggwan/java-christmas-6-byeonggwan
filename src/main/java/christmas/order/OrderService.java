package christmas.order;

import christmas.menu.MenuItem;
import christmas.menu.MenuService;
import java.util.HashMap;

public class OrderService {
    private MenuService menuService;
    private HashMap<MenuItem, Integer> order;
    private static final String invalidOrderMsg = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public OrderService() {
        menuService = new MenuService();
        order = new HashMap<>();
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
        }
        catch (IllegalArgumentException ex) {
            this.order.clear();
            throw ex;
        }
    }
}
