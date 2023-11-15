package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.menu.MenuItem;
import christmas.menu.MenuService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuServiceTest {

    @DisplayName("메뉴 이름으로 주문할 수 있다.")
    @Test
    void orderByName() {
        MenuService menuService = new MenuService();

        String menuName = "양송이수프";
        MenuItem menu = menuService.order(menuName);

        assertThat(menu).isNotNull();
        assertThat(menu.getName()).isEqualTo(menuName);
        assertThat(menu.getCategory()).isEqualTo("애피타이저");
        assertThat(menu.getPrice()).isEqualTo(6000);
    }

    @DisplayName("존재하지 않는 메뉴 이름으로 메뉴를 찾으면 null을 반환한다.")
    @Test
    void orderByNonexistentName() {
        MenuService menuService = new MenuService();

        String menuName = "존재하지않는메뉴";
        MenuItem menu = menuService.order(menuName);

        assertThat(menu).isNull();
    }
}