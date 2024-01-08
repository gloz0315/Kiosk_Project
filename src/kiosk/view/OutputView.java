package kiosk.view;

import kiosk.model.Category;
import kiosk.model.Item;
import kiosk.model.MenuList;
import kiosk.others.TimeDelay;

import java.util.Map;

public class OutputView {
    private static String formatType1 = "%d. %-15s | W %.1f | %s\n";
    private static String formatType2 = "%-15s | %d개 | W %.1f | %s\n";
    private static String formatType3 = "- %-15s | W %.1f | %d개\n";
    private static String formatType4 = "%d. %-10s | %s\n";
    private static String formatType5 = "\"%-15s | W %.1f | %s\" \n";
    private static String formatType6 = "W %.1f\n";

    private final String welcome = "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"";
    private final String selectMainMenu = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n";
    private final String shakeshackMenu = "[ SHAKESHACK MENU ]";
    private final String orderMenu = "[ ORDER MENU ]";

    private final String burgersMenu = "[ Burgers Menu ]";
    private final String iceCreamMenu = "[ Ice Cream Menu ]";
    private final String drinkMenu = "[ Drinks Menu ]";
    private final String friedMenu = "[ Fried Menu ]";
    private final String selectMenu = "아래 상품 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n";
    private final String addMenu = "위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인     2. 취소";
    private final String typeMenu = "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n1. Single(W %.1f)     2. Double(W %.1f)\n";

    private final String emptyBasket = "장바구니에 물건이 없습니다.";
    private final String orderBasket = "아래와 같이 주문하시겠습니까?\n";
    private final String order = "[ Orders ]";
    private final String total = "[ Total ]";

    private final String cancelBasket = "진행하던 주문을 취소하시겠습니까?\n1. 확인    2. 취소\n";

    private final String emptyDatabase = "총 판매된 메뉴들이 없습니다.";
    private final String totalSellInfo = "[ 총 판매상품 목록 현황 ]\n현재까지 총 판매된 상품 목록은 아래와 같습니다.\n";
    private final String totalSellPrice = "[ 총 판매금액 현황 ]\n현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n";

    private final String goToPrev = "이전 화면으로 이동하게 됩니다.\n";
    private final String exitMenu = "0. 나가기\n";

    public void printMainMenu() {
        System.out.println(welcome);
        System.out.println(selectMainMenu);

        for(Category category: Category.values()) {
            if(category.typeNumber() == 1) {
                System.out.println(shakeshackMenu);
            } else if(category.typeNumber() == 5) {
                System.out.println("\n" + orderMenu);
            }

            System.out.printf(formatType4,category.typeNumber(),category.getType(),category.typeDescription());
        }
        System.out.println();
    }

    public void printMenuList(Category category) {
        System.out.println(selectMenu);

        switch(category) {
            case BURGERTYPE:
                System.out.println(burgersMenu);
                burgerMenuList();
                break;

            case ICECREAMTYPE:
                System.out.println(iceCreamMenu);
                icecreamMenuList();
                break;

            case DRINKTYPE:
                System.out.println(drinkMenu);
                drinkMenuList();
                break;

            case FRIEDTYPE:
                System.out.println(friedMenu);
                friedMenuList();
                break;
        }
    }

    // 이전 화면으로 이동
    public void backToPrev() {
        System.out.println(goToPrev);
    }

    public void menuListInfo(MenuList menuListInfo, int type) {
        if(type == 1) {
            System.out.printf(formatType5,menuListInfo.menuName(),menuListInfo.getSinglePrice(),menuListInfo.menuDescription());
        } else {
            System.out.printf(formatType5,menuListInfo.menuName(),menuListInfo.getDoublePrice(),menuListInfo.menuDescription());
        }
        System.out.println(addMenu);
        System.out.println();
    }

    public void menuListType(MenuList menuListInfo) {
        System.out.printf(formatType5,menuListInfo.menuName(),menuListInfo.getSinglePrice(),menuListInfo.menuDescription());
        System.out.printf(typeMenu,menuListInfo.getSinglePrice(),menuListInfo.getDoublePrice());
        System.out.println();
    }

    public void addBasket(String name) {
        System.out.println(name + " 가 장바구니에 추가되었습니다.");
    }

    public void basketEmpty() {
        System.out.println(emptyBasket);
        backToPrev();
    }

    public void databaseEmpty() {
        System.out.println(emptyDatabase);
        backToPrev();
    }

    public void databaseInfo(Map<Item,Integer> database, double totalPrice) {
        System.out.println();
        System.out.println(totalSellInfo);
        for(Map.Entry<Item, Integer> item : database.entrySet()) {
            System.out.printf(formatType3,item.getKey().getName(), item.getKey().itemPrice(), item.getValue());
        }
        System.out.println();
        System.out.printf(totalSellPrice,totalPrice);
        System.out.println("1. 돌아가기\n");
    }

    public void orderBasket(Map<Item,Integer> basket, double totalPrice) {
        System.out.println(orderBasket);
        System.out.println(order);
        for(Map.Entry<Item,Integer> itemInfo : basket.entrySet()) {
            System.out.printf(formatType2,itemInfo.getKey().getName(),itemInfo.getValue(),
                    itemInfo.getKey().itemPrice(),itemInfo.getKey().getDescription());
        }
        System.out.println();
        System.out.println(total);
        System.out.printf(formatType6,totalPrice);
        System.out.println("\n1. 주문    2. 메뉴판\n");
    }

    public void orderComplete(int waitingNumber) {
        System.out.println("주문이 완료되었습니다.\n");
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n",waitingNumber);
        TimeDelay.delay();
    }

    public void cancelBasket() {
        System.out.println(cancelBasket);
    }

    public void cancelComplete() {
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    private void burgerMenuList() {
        for(MenuList menuList : MenuList.values()) {
            if(menuList.getType().equals("Burger")) {
                System.out.printf(formatType1,menuList.menuNumber(),menuList.menuName()
                        ,menuList.getSinglePrice(),menuList.menuDescription());
            }
        }
        System.out.println();
        System.out.println(exitMenu);
    }

    private void icecreamMenuList() {
        for(MenuList menuList : MenuList.values()) {
            if(menuList.getType().equals("Icecream")) {
                System.out.printf(formatType1,menuList.menuNumber(),menuList.menuName()
                        ,menuList.getSinglePrice(),menuList.menuDescription());
            }
        }
        System.out.println();
        System.out.println(exitMenu);
    }

    private void drinkMenuList() {
        for(MenuList menuList : MenuList.values()) {
            if(menuList.getType().equals("Drink")) {
                System.out.printf(formatType1,menuList.menuNumber(),menuList.menuName()
                        ,menuList.getSinglePrice(),menuList.menuDescription());
            }
        }
        System.out.println();
        System.out.println(exitMenu);
    }

    private void friedMenuList() {
        for(MenuList menuList : MenuList.values()) {
            if(menuList.getType().equals("Fried")) {
                System.out.printf(formatType1,menuList.menuNumber(),menuList.menuName()
                        ,menuList.getSinglePrice(),menuList.menuDescription());
            }
        }
        System.out.println();
        System.out.println(exitMenu);
    }
}
