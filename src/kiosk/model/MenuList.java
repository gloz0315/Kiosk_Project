package kiosk.model;

public enum MenuList {
    SHACKBURGUER(1,"ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6.9,9.9,"Burger"),
    SMOKESHACK(2,"SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8.9,11.9,"Burger"),
    SHROOMBURGER(3,"ShroomBurger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9.4,12.4,"Burger"),
    CHEESEBURGER(4,"CheeseBurger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6.9,9.9,"Burger"),
    HAMBURGER(5,"Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5.4,8.9,"Burger"),

    PEACHTEA(1,"Peach Tea","복숭아 티",3.5,4.8,"Drink"),
    LEMONTEA(2,"Lemon Tea","레몬 티",3.5,4.8,"Drink"),
    GREENTEA(3,"Green Tea","녹차 티",2.8,4.0,"Drink"),

    CHEESEFRIED(1,"Cheese Fried","치즈가 잔뜩 들어간 감자튀김",2.8,4.0,"Fried"),
    FRIED(2,"Fried","짭짤한 맛이 일품인 감자튀김",1.5,2.5,"Fried"),

    CHOCOLATE(1,"Chocolate Ice","초코 시럽이 듬뿍 들어간 아이스크림",1.5,2.5,"Icecream"),
    VANILLA(2,"Vanilla Ice","바닐라 향이 진한 아이스크림",1.2,2.2,"Icecream");

    private final int number;
    private final String name;
    private final String description;
    private final double singlePrice;
    private final double doublePrice;
    private final String type;

    MenuList(int number, String name, String description, double singlePrice, double doublePrice,String type) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
        this.type = type;
    }

    public static MenuList getMenuListInfo(int number,String type) {
        int count = 1;
        for(MenuList menuList : MenuList.values()) {
            if(menuList.type.equals(type) && menuList.number == number)
                return menuList;

            if(menuList.type.equals(type))
                count++;
        }
        throw new IllegalArgumentException();
    }

    public static Item menuListItem(MenuList menuListInfo, int number) {
        if(number == 1)
            return new Item(menuListInfo.name,menuListInfo.description,menuListInfo.singlePrice);

        return new Item(menuListInfo.name,menuListInfo.description,menuListInfo.doublePrice);
    }

    public int menuNumber() {
        return number;
    }

    public String menuName() {
        return name;
    }

    public String menuDescription() {
        return description;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public double getDoublePrice() {
        return doublePrice;
    }

    public String getType() {
        return type;
    }
}
