package ch14.sec03.exam04;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread(); // 메인 스레드의 참조를 얻음
        System.out.println(mainThread.getName() + " 실행");   // 메인 스레드 : main
        
        for(int i = 0; i < 3; i++) {
            // 각기 다른 스레드 3개를 생성함.
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    // 스레드 이름 리턴
                    System.out.println(getName() + " 실행");  // Thread-0, 1, 2
                }
            };
            threadA.start();
        }
        
        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");    // 작업 스레드 이름 변경
        chatThread.start();

        // 어떤 스레드가 먼저 실행되는지는 보장할 수 없음. = 순서가 제멋대로임.
    }
}
