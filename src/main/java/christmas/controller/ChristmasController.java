package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private InputView inputView;
    private OutputView outputView;

    public ChristmasController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        hello();
        askDay();
    }

    private void hello() {
        outputView.hello();
    }

    private void askDay() {
        outputView.printAskDay();
        Integer day;
        boolean isDone = false;
        while (!isDone) {
            try {
                day = inputView.inputDay();
                isDone = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
