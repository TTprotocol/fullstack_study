package ch17.exam.parents_gift_suggester.step3;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.util.List;

public class MostValuableGift {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();
        boolean momMode = false;

        System.out.println("\uD83D\uDC8E 부모님께 드릴 수 있는 최고의 프리미엄 선물");
        if (momMode) {
            item.stream()
                .filter(s -> s.isForMom())
                .sorted((a, b) -> Integer.compare(b.getPrice(), a.getPrice()))
                .findFirst()
                .ifPresentOrElse(
                    s ->
                        System.out.println(
                            "[" +
                                s.getName() +
                                "] - " +
                                s.getCategory() +
                                " (\u20A9" + s.getPrice() +
                                ") / 선호도: " +
                                s.getPreferenceScore() +
                                "점"
                        ),
                    () -> System.out.println("\uD83D\uDE22 조건에 맞는 고가의 선물을 찾지 못했어요.")
                );
        } else {
            item.stream()
                .filter(s -> s.isForDad() && s.getPreferenceScore() >= 100)
                .sorted((a, b) -> Integer.compare(b.getPrice(), a.getPrice()))
                .findFirst()
                .ifPresentOrElse(
                    s ->
                        System.out.println(
                            "[" +
                                s.getName() +
                                "] - " +
                                s.getCategory() +
                                " (\u20A9" + s.getPrice() +
                                ") / 선호도: " +
                                s.getPreferenceScore() +
                                "점"
                        ),
                    () -> System.out.println("\uD83D\uDE22 조건에 맞는 고가의 선물을 찾지 못했어요.")
                );
        }
    }
}
