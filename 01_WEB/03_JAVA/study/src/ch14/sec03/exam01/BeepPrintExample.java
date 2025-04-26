package ch14.sec03.exam01;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try { Thread.sleep(500); } catch (Exception e) {}
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch (Exception e) {}
        }

        // 하나의 스레드에서 실행되었기 때문에 beep음이 모두 들리고 난 후에 문자가 출력된다.
    }
}
