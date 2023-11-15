package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String invalidDayMsg = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
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
}
