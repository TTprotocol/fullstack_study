package ch17.exam.parents_gift_suggester.step1;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.util.List;

public class HighPreferenceFilter {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        System.out.println("\uD83C\uDF81 부모님이 진짜 좋아하시는 선물 리스트");
        item.stream()
            .filter(s -> s.getPreferenceScore() > 70)
            .map(GiftItem::getName)
            .forEach(System.out::println);
    }
}
