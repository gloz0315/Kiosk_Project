package kiosk.model.MenuList;

public enum Burger {

    SHACKBURGUER(1,"ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6.9,9.9),
    SMOKESHACK(2,"SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8.9,11.9),
    SHROOMBURGER(3,"ShroomBurger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9.4,12.4),
    CHEESEBURGER(4,"CheeseBurger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6.9,9.9),
    HAMBURGER(5,"Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5.4,8.9);

    private final int number;
    private final String name;
    private final String description;
    private final double singlePrice;
    private final double doublePrice;

    Burger(int number, String name, String description, double singlePrice, double doublePrice) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
    }

    public static Burger getBurgerInfo(int burgerNumber) {
        int count = 1;
        for(Burger burger : Burger.values()) {
            if(burgerNumber == burger.number)
                return burger;

            count++;
        }
        return null;
    }

    public int burgerNumber() {
        return number;
    }

    public String burgerName() {
        return name;
    }

    public String burgerDescription() {
        return description;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public double getDoublePrice() {
        return doublePrice;
    }
}
