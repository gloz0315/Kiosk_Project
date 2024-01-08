package kiosk.model;

import java.util.HashMap;
import java.util.Map;

// 상품 판매된 정보들을 저장하는 클래스
public class Database {
    private static Database databaseInfo;
    private final Map<Item,Integer> sellInfo;
    private int waitingNumber = 1;

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

    public boolean containItem(Item itemInfo, int number) {
        for (Map.Entry<Item,Integer> item : sellInfo.entrySet()) {
            if(item.getKey().getName().equals(itemInfo.getName()) && item.getKey().itemPrice() == itemInfo.itemPrice()) {
                sellInfo.replace(item.getKey(), item.getValue(), item.getValue() + number);
                return true;
            }
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

    public int getWaitingNumber() {
        return waitingNumber++;
    }

    public Map<Item,Integer> getSellInfo() {
        return sellInfo;
    }
}
