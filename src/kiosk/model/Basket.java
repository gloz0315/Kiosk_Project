package kiosk.model;

import java.util.HashMap;
import java.util.Map;

// 바구니 클래스, 메뉴들의 정보를 담는 클래스
public class Basket {
    // 싱글톤 패턴을 구현하여 장바구니 하나만 가지고 만들기
    private static Basket basketInfo;
    private final Map<Item,Integer> buyInfo;

    private Basket() {
        buyInfo = new HashMap<>();
    }

    public static Basket getInstance() {
        if(basketInfo == null) {
            basketInfo = new Basket();
        }

        return basketInfo;
    }

    public boolean isEmpty() {
        return buyInfo.isEmpty();
    }

    public boolean containItem(Item itemInfo) {
        for(Map.Entry<Item,Integer> item : buyInfo.entrySet()) {
            if(item.getKey().getName().equals(itemInfo.getName()) && item.getKey().itemPrice() == itemInfo.itemPrice()) {
                buyInfo.replace(item.getKey(),item.getValue(), item.getValue() + 1);
                return true;
            }
        }
        return false;
    }

    public void addItem(Item itemInfo, int count) {
        buyInfo.put(itemInfo, count);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;

        for(Map.Entry<Item,Integer> item : buyInfo.entrySet()) {
            totalPrice += item.getKey().itemPrice() * item.getValue();
        }

        return totalPrice;
    }

    public void clearBasket() {
        buyInfo.clear();
    }

    public Map<Item,Integer> getBasket() {
        return buyInfo;
    }

}
