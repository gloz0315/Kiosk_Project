package kiosk.service;

import kiosk.model.Basket;
import kiosk.model.Category;
import kiosk.model.Item;
import kiosk.model.MenuList;
import kiosk.others.Invalidate;
import kiosk.others.TimeDelay;
import kiosk.view.InputView;
import kiosk.view.OutputView;

public class MenuService {
    private Category category;
    private MenuList menuList;
    private OutputView outputView;

    public MenuService() {
        outputView = new OutputView();
    }

    public void menuServiceRun(Category category) {
        this.category = category;

        while(true) {
            outputView.printMenuList(category);
            int number = InputView.matchPattern(InputView.inputView());
            if(number == 0) {
                outputView.backToPrev();
                return;
            }
            selectMenu(number);
        }
    }

    private void selectMenu(int number) {
        try {
            menuType(category,number);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못입력하셨습니다. 다시 입력해주세요.\n");
        }
    }

    private void menuType(Category category, int number) {
        Item item = null;

        switch(category) {
            case BURGERTYPE :
                menuList = MenuList.getMenuListInfo(number,"Burger");
                break;
            case DRINKTYPE :
                menuList = MenuList.getMenuListInfo(number,"Drink");
                break;
            case FRIEDTYPE :
                menuList = MenuList.getMenuListInfo(number,"Fried");
                break;
            case ICECREAMTYPE :
                menuList = MenuList.getMenuListInfo(number,"Icecream");
                break;
        }
        addItems(menuItem(menuList));
    }

    private Item menuItem(MenuList menuListInfo) {
        System.out.println();
        outputView.menuListType(menuListInfo);
        int type = Invalidate.typeException();
        System.out.println();
        outputView.menuListInfo(menuListInfo,type);
        Invalidate.typeException();
        return MenuList.menuListItem(menuListInfo,type);
    }

    private void addItems(Item item) {
        if(!Basket.getInstance().containItem(item))
            Basket.getInstance().addItem(item,1);

        System.out.println();
        outputView.addBasket(item.getName());
        TimeDelay.delay();
    }
}
