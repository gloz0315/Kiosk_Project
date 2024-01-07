package kiosk.model.MenuList;

public enum Fried {
    ;

    private final int number;
    private final String name;
    private final String description;
    private final double singlePrice;
    private final double doublePrice;

    Fried(int number, String name, String description, double singlePrice, double doublePrice) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
    }

    public static Fried getFriedInfo(int number) {
        int count = 1;
        for(Fried fried : Fried.values()) {
            if(number == fried.friedNumber())
                return fried;

            count++;
        }
        return null;
    }

    public int friedNumber() {
        return number;
    }

    public String friedName() {
        return name;
    }

    public String friedDescription() {
        return description;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public double getDoublePrice() {
        return doublePrice;
    }
}
