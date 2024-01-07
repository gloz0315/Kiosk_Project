package kiosk.model;

import java.util.HashMap;
import java.util.Map;

// 상품 판매된 정보들을 저장하는 클래스
public class Database {
    private static Database databaseInfo;
    private final Map<Item,Integer> sellInfo;

    private Database() {
        sellInfo = new HashMap<>();
    }

    public static Database getInstance() {
        if(databaseInfo == null) {
            databaseInfo = new Database();
        }

        return databaseInfo;
    }

    public boolean isEmpty() {
        return sellInfo.isEmpty();
    }

    public boolean containItem(Item itemInfo) {
        for (Item item : sellInfo.keySet()) {
            if(item.getName().equals(itemInfo.getName()) && item.itemPrice() == itemInfo.itemPrice())
                return true;
        }

        return false;
    }

    public void addItem(Item itemInfo, int count) {
        sellInfo.put(itemInfo, count);
    }


    public double getTotalPrice() {
        double totalPrice = 0.0;

        for(Map.Entry<Item,Integer> item : sellInfo.entrySet()) {
            totalPrice += item.getKey().itemPrice() * item.getValue();
        }

        return totalPrice;
    }
}
