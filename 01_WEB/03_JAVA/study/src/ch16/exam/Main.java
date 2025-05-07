package ch16.exam;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
//        TicketFactory factory = new MetaMonTicketFactory();
//        Ticket jiwoo = factory.create("지우");
//        Ticket isul = factory.create("이슬이");
//
//        System.out.println();
//
//        jiwoo.enter();
//        isul.enter();

        List<Goods> goods = Arrays.asList(
                new Goods("메타몽 쿠션", "분홍", false),
                new Goods("메타몽 노트북 파우치", "보라", true),
                new Goods("메타몽 인형", "분홍", false),
                new Goods("메타몽 가방", "회색", true),
                new Goods("메타몽 키링", "파랑", false)
        );

//        printSelectedGoods("이슬이", goods, g -> g.getColor().equals("분홍"));
//        printSelectedGoods("지우", goods, Goods::isUseful);

//        List<Goods> pick1 = pickGifts(goods);
//        printResult("이슬이", pick1, g->g.getColor().equals("분홍"), "→ 성공! 분홍색 굿즈를 얻었어요!", "→ 실패! 유용한 굿즈가 없어요");
//        System.out.println();
//        List<Goods> pick2 = pickGifts(goods);
//        printResult("지우", pick2, Goods::isUseful, "→ 성공! 유용한 굿즈를 얻었어요!", "→ 실패! 유용한 굿즈가 없어요");


        PhotoAlbum photoAlbum = new PhotoAlbum();
        Consumer<Photo> comsumer = t -> System.out.println();
    }

//    public static void printSelectedGoods(String user, List<Goods> goodsList, Predicate<Goods> filter) {
//        System.out.println("[" + user + "의 선택]");
//        goodsList.stream()
//                .filter(filter)
//                .map(Goods::getName)
//                .forEach(name -> System.out.println("- " + name));
//        System.out.println();
//    }
//
//    public static List<Goods> pickGifts(List<Goods> pool) {
//        if (pool.size() < 2) {
//            throw new IllegalArgumentException("남은 굿즈가 2개 이상이어야 합니다.");
//        }
//
//        Random rand = new Random();
//        List<Goods> pools = new ArrayList<>(pool);
//        List<Goods> get = new ArrayList<>();
//
//        // 첫 번째 아이템 뽑기
//        int index1 = rand.nextInt(pool.size());
//        get.add(pools.remove(index1));
//
//        // 두 번째 아이템 뽑기
//        int index2 = rand.nextInt(pool.size());
//        get.add(pools.remove(index2));
//
//        return get;
//    }
//
//    public static void printResult(
//            String user,
//            List<Goods> picks,
//            Predicate<Goods> condition,
//            String successMsg,
//            String failMsg
//    ) {
//        System.out.println("[" + user + "]의 뽑기 결과");
//        picks.forEach(name -> System.out.println("- " + name));
//        boolean result = picks.stream().anyMatch(condition);
//
//        if (result) {
//            System.out.println(successMsg);
//        } else {
//            System.out.println(failMsg);
//        }
//    }
}
