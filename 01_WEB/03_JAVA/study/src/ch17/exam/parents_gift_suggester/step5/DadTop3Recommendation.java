package ch17.exam.parents_gift_suggester.step5;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;

public class DadTop3Recommendation {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        DecimalFormat formatter = new DecimalFormat("#,###");

        List<GiftItem> itemFiltered = item.stream()
            .filter(GiftItem::isForDad)
            .sorted((a, b) -> Integer.compare(b.getPreferenceScore(), a.getPreferenceScore()))
            .limit(3)
            .toList();

        if (itemFiltered.isEmpty()) {
            System.out.println("\uD83D\uDE2D 아빠를 위한 추천 선물이 없습니다.");
            return;
        }

        int maxPrice = itemFiltered.stream().mapToInt(GiftItem::getPrice).max().orElse(0);
        int minPrice = itemFiltered.stream().mapToInt(GiftItem::getPrice).min().orElse(0);

        System.out.println("\uD83C\uDF81 아빠가 좋아하실 감동 추천 Top 3");

        itemFiltered.stream()
            .map(gift -> {
                int index = itemFiltered.indexOf(gift) + 1;

                String badge = gift.getPrice() == maxPrice ? " \uD83D\uDC8E" :
                    gift.getPrice() == minPrice ? " \uD83D\uDCB8" : "";

                String starts = "★".repeat(gift.getPreferenceScore() / 20) +
                    "☆".repeat(5 - (gift.getPreferenceScore() / 20));

                return String.format(
                    "%d. [%s] - %s / ₩%s원 / 선호도: %d점 (%s)%s",
                    index,
                    gift.getName(),
                    gift.getCategory(),
                    formatter.format(gift.getPrice()),
                    gift.getPreferenceScore(),
                    starts,
                    badge
                );
            })
            .forEach(System.out::println);
        System.out.println();

        double avgPref = itemFiltered.stream().mapToInt(GiftItem::getPreferenceScore).average().orElse(0.0);
        double avgPrice = itemFiltered.stream().mapToInt(GiftItem::getPrice).average().orElse(0.0);

        System.out.println("\uD83D\uDCCA 평균 선호도: " + avgPref + "점");
        System.out.println("\uD83D\uDCCA 평균 가격: ₩" + formatter.format((int) avgPrice) + "원");

    }
}
