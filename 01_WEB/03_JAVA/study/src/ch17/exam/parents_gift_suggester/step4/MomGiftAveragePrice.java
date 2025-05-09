package ch17.exam.parents_gift_suggester.step4;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;

public class MomGiftAveragePrice {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        DecimalFormat formatter = new DecimalFormat("#,###");

        System.out.println("\uD83D\uDC69 엄마 전용 선물들의 평균 가격 리포트");
        System.out.println("\uD83D\uDCE6 포함된 선물:");

        item.stream()
            .filter(s -> s.isForMom() && s.getPreferenceScore() >= 100)
            .map(GiftItem::getName)
            .forEach(s -> System.out.println("- " + s));

        item.stream()
            .filter(s -> s.isForMom() && s.getPreferenceScore() >= 100)
            .mapToInt(GiftItem::getPrice)
            .average()
            .ifPresentOrElse(
                avg -> System.out.println("\uD83D\uDCCA 평균 가격: ₩" + formatter.format(avg) + "원"),
                () -> System.out.println("\uD83D\uDE2D 조건에 맞는 엄마 전용 선물이 아직 없습니다.")
            );

    }
}
