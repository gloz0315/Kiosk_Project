package kiosk.console;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    public static String readLine() {
        System.out.print("숫자를 입력하세요 > ");
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if(scanner == null)
            scanner = new Scanner(System.in);

        return scanner;
    }
}
