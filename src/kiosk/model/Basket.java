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

}
