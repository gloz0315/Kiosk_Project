package kiosk.model.MenuList;

public enum IceCream {
    ;

    private final int number;
    private final String name;
    private final String description;
    private final double singlePrice;
    private final double doublePrice;

    IceCream(int number, String name, String description, double singlePrice, double doublePrice) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
    }

    public static IceCream getIceCreamInfo(int number) {
        int count = 1;
        for(IceCream iceCream : IceCream.values()) {
            if(number == iceCream.iceCreamNumber())
                return iceCream;

            count++;
        }
        return null;
    }

    public int iceCreamNumber() {
        return number;
    }

    public String iceCreamName() {
        return name;
    }

    public String iceCreamDescription() {
        return description;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public double getDoublePrice() {
        return doublePrice;
    }
}
