package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        // 새 스레드 인스턴스를 생성. Runnable이라는 클래스 인스턴스를 위임하였다.
        Thread thread = new Thread(new Runnable() { // 익명 구현 객체 => Runnable 인터페이스의 run() 메서드를 구현.
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try { Thread.sleep(500); } catch (Exception e) {}
                }
            }
        });

        // 작업 스레드 실행.
        // start() 메서드는 run() 메서드를 실행시키는 역할을 한다.
        // 만약 start() 메서드를 실행하지 않고 run() 메서드를 바로 실행할 경우, 이 스레드는 메인 스레드에서 실행된다
        // = exam01과 동일한 상황
        thread.start();

        // 문자 출력은 메인 스레드에서 진행된다.
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}
