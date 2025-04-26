package ch14.sec03.exam03;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        // 이번에는 Thread 클래스를 상속받아 run() 메서드를 오버라이딩 했다.
        Thread thread = new Thread() {  // 익명 객체 상속 후 바로 run() 메서드 오버라이딩.
            @Override public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try { Thread.sleep(500); } catch(Exception e) {}
                }
            }
        };

        thread.start();

        for(int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
