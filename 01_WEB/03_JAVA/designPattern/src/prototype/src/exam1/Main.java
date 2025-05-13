package exam1;

import framework.Manager;
import framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        CardTemplate card1 = new CardTemplate("Instagram Post", "~");
        CardTemplate card2 = new CardTemplate("YouTube Thumbnail", "#");

        manager.register("insta", card1);
        manager.register("youtube", card2);

        Product p1 = manager.create("insta");
        p1.use("오늘 점심은 연남동 김밥 \uD83C\uDF59");
        System.out.println();
        Product p2 = manager.create("youtube");
        p2.use("\uD83D\uDD25자바로 구현한 내 인생 첫 프로그램!");
    }
}
