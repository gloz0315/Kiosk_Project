package kiosk.controller;

import kiosk.model.Category;
import kiosk.service.MenuService;
import kiosk.service.OtherService;
import kiosk.view.InputView;
import kiosk.view.OutputView;

public class MainController {
    private final MenuService menuService;
    private final OtherService otherService;
    private final OutputView outputView;

    public MainController() {
        this.menuService = new MenuService();
        this.otherService = new OtherService();
        outputView = new OutputView();
    }

    public void run() {
        while(true) {
            mainMenu();
        }
    }

    private void mainMenu() {
        try {
            outputView.printMainMenu();
            int number = InputView.matchPattern(InputView.inputView());
            selectMenu(number);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못입력하셨습니다. 메인화면으로 이동합니다.\n");
        }
    }

    private void selectMenu(int number) {
        Category category = Category.getCategoryInfo(number);

        switch(category) {
            case BURGERTYPE,ICECREAMTYPE,DRINKTYPE,FRIEDTYPE: {
                menuService.menuServiceRun(category);
            }
            break;
            case ORDERTYPE: {
                otherService.orderMenu();
            }
            break;
            case CANCELTYPE: {
                otherService.cancelMenu();
            }
            break;
            case SALESTYPE: {
                otherService.sellMenu();
            }
            break;

            default:
                break;
        }
    }
}
