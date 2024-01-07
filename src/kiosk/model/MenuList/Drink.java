package kiosk.model.MenuList;

public enum Drink {
    PEACHTEA(1,"Peach Tea","복숭아 티",3.5,4.8),
    LEMONTEA(2,"Lemon Tea","레몬 티",3.5,4.8),
    GREENTEA(3,"Green Tea","녹차 티",2.8,4.0);

    private final int number;
    private final String name;
    private final String description;
    private final double smallPrice;
    private final double largePrice;

    Drink(int number, String name, String description, double smallPrice, double largePrice) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.smallPrice = smallPrice;
        this.largePrice = largePrice;
    }

    public static Drink getDrinkInfo(int number) {
        int count = 1;
        for(Drink drink : Drink.values()) {
            if(number == drink.drinkNumber())
                return drink;

            count++;
        }
        return null;
    }

    public int drinkNumber() {
        return number;
    }

    public String drinkName() {
        return name;
    }

    public String drinkDescription() {
        return description;
    }

    public double getSmallPrice() {
        return smallPrice;
    }

    public double getLargePrice() {
        return largePrice;
    }
}
