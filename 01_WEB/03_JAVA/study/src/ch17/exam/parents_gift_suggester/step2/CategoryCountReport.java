package ch17.exam.parents_gift_suggester.step2;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryCountReport {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        System.out.println("\uD83D\uDCE6 카테고리별 선물 개수 요약");
        item.stream().collect(
            Collectors.groupingBy(s -> s.getCategory())
        ).forEach( (key, value) -> {
            System.out.println(key + " : " + value.size() + "개");
            
        });

    }
}
