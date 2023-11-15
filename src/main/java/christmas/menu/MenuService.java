package christmas.menu;

import java.util.HashMap;

public class MenuService {
    private HashMap<String, MenuItem> menu;

    public MenuService() {
        this.menu = new HashMap<>();
        setChristmasMenu();
    }

    private void setChristmasMenu() {
        menu.put("양송이수프", new MenuItem("양송이수프", "애피타이저", 6000));
        menu.put("타파스", new MenuItem("타파스", "애피타이저", 5500));
        menu.put("시저샐러드", new MenuItem("시저샐러드", "애피타이저", 8000));
        menu.put("티본스테이크", new MenuItem("티본스테이크", "메인", 55000));
        menu.put("바비큐립", new MenuItem("바비큐립", "메인", 54000));
        menu.put("해산물파스타", new MenuItem("해산물파스타", "메인", 35000));
        menu.put("크리스마스파스타", new MenuItem("크리스마스파스타", "메인", 25000));
        menu.put("초코케이크", new MenuItem("초코케이크", "디저트", 15000));
        menu.put("아이스크림", new MenuItem("아이스크림", "디저트", 5000));
        menu.put("제로콜라", new MenuItem("제로콜라", "음료", 3000));
        menu.put("레드와인", new MenuItem("레드와인", "음료", 60000));
        menu.put("샴페인", new MenuItem("샴페인", "음료", 25000));
    }

    public MenuItem order(String menuName) {
        return menu.get(menuName);
    }
}
