package kiosk.others;

import kiosk.view.InputView;

public class Invalidate {
    public static int typeException() {
        int type = InputView.matchPattern(InputView.inputView());

        if(type <= 0 || type > 2)
            throw new IllegalArgumentException();

        return type;
    }

    public static void sellException() {
        int number = InputView.matchPattern(InputView.inputView());

        if(number != 1)
            throw new IllegalArgumentException();
    }
}
