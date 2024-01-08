package kiosk.view;

import kiosk.console.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static int matchPattern(String number) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        if(matcher.matches()) {
            return Integer.parseInt(number);
        }

        throw new IllegalArgumentException();
    }
    public static String inputView() {
        System.out.print("숫자를 입력하세요 > ");
        return Console.readLine();
    }
}
