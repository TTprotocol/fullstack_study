package adapter.adapter2;

import adapter.adapter1.Banner;

public class Main {
    public static void main(String[] args) {
//        Print p = new PrintBanner("Hello");
//        p.printWeak();
//        p.printStrong();

        print(new PrintBanner(new Banner("Hello Banner")));
    }

    // 고정된 사용자 측 코드
    public static void print(Print p) {
        p.printWeak();
        p.printStrong();
    }
}
