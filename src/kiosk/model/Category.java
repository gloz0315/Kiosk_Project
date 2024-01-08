package kiosk.model;

public enum Category {
    BURGERTYPE(1,"Burgers","앵거스 비프 통살을 다져만든 버거"),
    ICECREAMTYPE(2,"Ice Cream","매장에서 신선하게 만드는 아이스크림"),
    DRINKTYPE(3,"Drinks","매장에서 직접 만드는 음료"),
    FRIEDTYPE(4,"Fried","뉴욕 브루클린 브루어리에서 만든 감자튀김"),
    ORDERTYPE(5,"Order","장바구니를 확인 후 주문합니다."),
    CANCELTYPE(6,"Cancel","진행중인 주문을 취소합니다."),
    SALESTYPE(7,"Sales","총 매출 정보를 보여줍니다.");

    private final int number;
    private final String type;
    private final String description;

    Category(int number, String type, String description) {
        this.number = number;
        this.type = type;
        this.description = description;
    }

    public static Category getCategoryInfo(int number) {
        int count = 1;
        for(Category category : Category.values()) {
            if(number == category.typeNumber())
                return category;
        }

        throw new IllegalArgumentException();
    }

    public int typeNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String typeDescription() {
        return description;
    }
}
