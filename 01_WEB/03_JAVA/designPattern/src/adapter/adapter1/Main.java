package adapter.adapter1;

public class Main {
    public static void main(String[] args) {
//        // Print 인터페이스에 어탭터를 참조시킨다.
//        Print p = new PrintBanner("Hello");
//        p.printWeak();
//        p.printStrong();

        print(new PrintBanner("Hello Banner"));
    }

    // 고정된 사용자 측 코드
    public static void print(Print p) {
        p.printWeak();
        p.printStrong();
    }
}
