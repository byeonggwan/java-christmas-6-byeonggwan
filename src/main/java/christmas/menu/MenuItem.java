package christmas.menu;


public class MenuItem {
    private String name;
    private int price;
    private String category;

    public MenuItem(String name, String category, int price) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
