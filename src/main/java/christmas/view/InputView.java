package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashMap;

public class InputView {
    private static final String invalidDayMsg = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String invalidOrderMsg = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public Integer inputDay() {
        String input = readLine();
        Integer day;
        try {
            day = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException(invalidDayMsg);
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(invalidDayMsg);
        }
        return day;
    }

    public HashMap<String, Integer> inputOrder() {
        String[] input = readLine().split(",");
        HashMap<String, Integer> menuMap = new HashMap<>();
        for (String nameAndCount : input) {
            String[] parts = nameAndCount.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException(invalidOrderMsg);
            }
            try {
                menuMap.put(parts[0], Integer.parseInt(parts[1]));
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException(invalidOrderMsg);
            }
        }
        return menuMap;
    }
}
