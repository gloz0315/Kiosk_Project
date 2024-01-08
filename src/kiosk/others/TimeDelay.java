package kiosk.others;

public class TimeDelay {
    private static void timeDelay() throws InterruptedException {
        for(int i = 3; i > 0; i--) {
            System.out.printf("[ %d초 뒤에 화면이 이동합니다. ]\n", i);
            Thread.sleep(1000);
        }
        System.out.println();
    }

    public static void delay() {
        try {
            TimeDelay.timeDelay();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
