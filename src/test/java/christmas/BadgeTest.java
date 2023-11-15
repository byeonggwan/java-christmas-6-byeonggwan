package christmas;
import christmas.event.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @DisplayName("Badge 값 확인 - 산타")
    @Test
    void badgeValueSanta() {
        Badge badge = Badge.valueOf(20000);
        assertEquals(Badge.SANTA, badge);
    }

    @DisplayName("Badge 값 확인 - 트리")
    @Test
    void badgeValueTree() {
        Badge badge = Badge.valueOf(19999);
        assertEquals(Badge.TREE, badge);
    }

    @DisplayName("Badge 값 확인 - 별")
    @Test
    void badgeValueStar() {
        Badge badge = Badge.valueOf(9999);
        assertEquals(Badge.STAR, badge);
    }

    @DisplayName("Badge 값 확인 - 없음")
    @Test
    void badgeValueNone() {
        Badge badge = Badge.valueOf(4999);
        assertEquals(Badge.NONE, badge);
    }
}
