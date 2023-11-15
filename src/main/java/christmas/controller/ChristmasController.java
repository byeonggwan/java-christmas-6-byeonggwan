package christmas.controller;

import christmas.order.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;

public class ChristmasController {
    private InputView inputView;
    private OutputView outputView;
    private OrderService orderService;

    public ChristmasController() {
        inputView = new InputView();
        outputView = new OutputView();
        orderService = new OrderService();
    }

    public void run() {
        hello();
        askDay();
        askOrder();
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

    private void askOrder() {
        outputView.printAskOrder();
        boolean isDone = false;
        while (!isDone) {
            try {
                HashMap<String, Integer> order = inputView.inputOrder();
                orderService.addByMap(order);
                isDone = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
