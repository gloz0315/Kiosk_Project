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
}
