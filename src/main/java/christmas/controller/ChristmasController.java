package christmas.controller;

import christmas.event.EventService;
import christmas.order.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;

public class ChristmasController {
    private InputView inputView;
    private OutputView outputView;
    private OrderService orderService;
    private EventService eventService;
    private Integer day;

    public ChristmasController() {
        inputView = new InputView();
        outputView = new OutputView();
        orderService = new OrderService();
        eventService = new EventService();
    }

    public void run() {
        hello();
        askDay();
        askOrder();
        startPreview();
        printOrder();
        printTotalPrice();
        printGift();
        printEvent();
        printTotalDisc();
        printLastPrice();
    }

    private void hello() {
        outputView.hello();
    }

    private void askDay() {
        outputView.printAskDay();
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

    private void startPreview() {
        outputView.printPreview(day);
    }

    private void printOrder() {
        outputView.printOrder(orderService.getOrder());
    }

    private void printTotalPrice() {
        outputView.printTotalPrice(orderService.getTotalPrice());
    }

    private void printGift() {
        outputView.printGift(orderService.getTotalPrice());
    }

    private void printEvent() {
        outputView.printDisc(eventService.apply(
                day,
                orderService.getCategoryCount("디저트"),
                orderService.getCategoryCount("메인"),
                orderService.getTotalPrice()
        ));
    }

    private void printTotalDisc() {
        outputView.printTotalDisc(eventService.getTotalDiscount(
                day,
                orderService.getCategoryCount("디저트"),
                orderService.getCategoryCount("메인"),
                orderService.getTotalPrice()
        ));
    }

    private void printLastPrice() {
        outputView.printLastPrice(orderService.getTotalPrice(), eventService.getTotalDiscountExceptGift(
                day,
                orderService.getCategoryCount("디저트"),
                orderService.getCategoryCount("메인"),
                orderService.getTotalPrice()
        ));
    }


}
